package caixaverso.agencias.service;

import caixaverso.agencias.dto.AgenciaDTO;
import caixaverso.agencias.dto.mapper.AgenciaMapper;
import caixaverso.agencias.exception.AgenciaJaExisteException;
import caixaverso.agencias.exception.AgenciaNaoExisteException;
import caixaverso.agencias.exception.CepNaoEncontradoException;
import caixaverso.agencias.model.Agencia;
import caixaverso.agencias.repository.AgenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@ApplicationScoped

public class AgenciaService {

    private final AgenciaRepository repository;

    private final ViaCepService viaCepService;

    public AgenciaService(AgenciaRepository repository, @RestClient ViaCepService viaCepService) {
        this.repository = repository;
        this.viaCepService = viaCepService;
    }

    public Agencia create(AgenciaDTO agenciaDto) {
        Agencia agencia = repository.findByCgc(agenciaDto.getCgc());
        if (agencia != null) {
            throw new AgenciaJaExisteException("Agencia ja cadastrada");
        }
        agencia = AgenciaMapper.toEntity(agenciaDto);
        buscarDadosCep(agencia);
        repository.persist(agencia);
        return agencia;
    }

    public AgenciaDTO getByCgc(int cgc) {
        return AgenciaMapper.toDto(findByCgc(cgc));
    }

    public List<AgenciaDTO> getAll() {
        return repository.findAll().list().stream().map(AgenciaMapper::toDto).toList();
    }

    public void update(int cgc, AgenciaDTO agenciaDto) {
        Agencia agencia = this.findByCgc(cgc);
        AgenciaMapper.updateAgencia(agenciaDto, agencia);
        if (agencia.getCep() != agenciaDto.getCep()) {
            buscarDadosCep(agencia);
        }
    }

    public void delete(int cgc) {
        Agencia agencia = this.findByCgc(cgc);
        repository.delete(agencia);
    }

    private Agencia findByCgc(int cgc) {
        Agencia agencia = repository.findByCgc(cgc);
        if (agencia == null) {
            throw new AgenciaNaoExisteException("Agencia com CGC " + cgc + " nao encontrada.");
        }
        return agencia;
    }

    public void updateParcial(int cgc, Map<String, Object> atualizacao) {
        Agencia agencia = findByCgc(cgc);
        atualizacao.forEach((key, value) -> {
            switch (key) {
                case "cgc":
                    agencia.setCgc(Integer.parseInt(value.toString()));
                    break;
                case "nome_agencia":
                    agencia.setNomeAgencia(value.toString());
                    break;
                case "nome_gestor":
                    agencia.setNomeGestor(value.toString());
                    break;
                case "data_inauguracao":
                    agencia.setDataInauguracao(LocalDate.parse(value.toString()));
                    break;
                case "cep":
                    agencia.setCep(value.toString());
                    buscarDadosCep(agencia);
                    break;
                case "numero":
                    agencia.setNumero(Integer.parseInt(value.toString()));
            }
        });
    }

    public void buscarDadosCep(Agencia agencia) {
        ViaCepResponse cepResponse = viaCepService.getCepInfo(agencia.getCep());
        if (cepResponse != null && !cepResponse.isErro()) {
            agencia.setCidade(cepResponse.getLocalidade());
            agencia.setEstado(cepResponse.getUf());
            agencia.setCep(cepResponse.getCep());
            agencia.setLogradouro(cepResponse.getLogradouro());
        } else throw new CepNaoEncontradoException("CEP não encontrado.");

    }

    public List<AgenciaDTO> getByUf(String uf) {
        List<Agencia> agencia = repository.findByUf(uf);
        if (agencia == null) {
            throw new AgenciaNaoExisteException("Agencia no estado " + uf + " nao encontrada.");
        }
        return agencia.stream().map(AgenciaMapper::toDto).toList();
    }

    public List<AgenciaDTO> getByCidade(String cidade) {
        List<Agencia> agencia = repository.findByCidade(cidade);
        if (agencia == null) {
            throw new AgenciaNaoExisteException("Agencia na cidade " + cidade + " nao encontrada.");
        }
        return agencia.stream().map(AgenciaMapper::toDto).toList();
    }
}
