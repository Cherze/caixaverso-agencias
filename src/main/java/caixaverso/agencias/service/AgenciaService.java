package caixaverso.agencias.service;

import caixaverso.agencias.dto.AgenciaDTO;
import caixaverso.agencias.dto.mapper.AgenciaMapper;
import caixaverso.agencias.exception.AgenciaJaExisteException;
import caixaverso.agencias.model.Agencia;
import caixaverso.agencias.repository.AgenciaRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped

public class AgenciaService{

    private final AgenciaRepository repository;

    public AgenciaService(AgenciaRepository repository) {
        this.repository = repository;
    }

    public Agencia create(AgenciaDTO agenciaDto){
        Agencia agencia = repository.findByCgc(agenciaDto.getCgc());
        if (agencia != null){
            throw new AgenciaJaExisteException("Agencia ja cadastrada");
        }
        agencia = AgenciaMapper.toEntity(agenciaDto);
        repository.persist(agencia);
        return agencia;
    }
    public void update(int cgc, AgenciaDTO agenciaDto){
        Agencia agencia = this.findByCgc(cgc);
        AgenciaMapper.updateAgencia(agenciaDto, agencia);
    }

    private Agencia findByCgc(int cgc) {
        Agencia agencia = repository.findByCgc(cgc);
        if (agencia == null) {
            //throw new TitleNotExistsException("Title with id " + id + " not found");
        }
        return agencia;
    }
}
