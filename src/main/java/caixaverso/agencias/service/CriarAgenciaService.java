package caixaverso.agencias.service;

import caixaverso.agencias.dto.AgenciaDTO;
import caixaverso.agencias.dto.mapper.AgenciaMapper;
import caixaverso.agencias.exception.AgenciaJaExisteException;
import caixaverso.agencias.model.Agencia;
import caixaverso.agencias.repository.AgenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped

public class CriarAgenciaService {

    private final AgenciaRepository repository;

    public CriarAgenciaService(AgenciaRepository repository) {
        this.repository = repository;
    }

    public Agencia create(AgenciaDTO agenciaDto){
        Optional<Agencia> optionalAgencia = repository.findByCgc(agenciaDto.getCgc());
        if (optionalAgencia.isPresent()){
            throw new AgenciaJaExisteException("Agencia ja cadastrada");
        }
        Agencia agencia = AgenciaMapper.toEntity(agenciaDto);
        repository.persist(agencia);
        return agencia;
    }
}
