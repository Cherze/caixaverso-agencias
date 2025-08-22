package caixaverso.agencias.dto.mapper;

import caixaverso.agencias.dto.AgenciaDTO;
import caixaverso.agencias.model.Agencia;

import java.util.Optional;

public class AgenciaMapper {

    public static Agencia toEntity(AgenciaDTO agenciaDTO) {
        Agencia agencia = new Agencia();
        agencia.setNomeAgencia(agenciaDTO.getNomeAgencia());
        agencia.setDataInauguracao(agenciaDTO.getDataInauguracao());
        agencia.setCgc(agenciaDTO.getCgc());
        agencia.setEndereco(agenciaDTO.getEndereco());
        agencia.setNomeGestor(agenciaDTO.getNomeGestor());
        return agencia;
    }
    public static Agencia updateAgencia(AgenciaDTO agenciaDto, Agencia agencia){
        if (agenciaDto == null){
            return null;
        }
        agencia.setNomeAgencia(agenciaDto.getNomeAgencia());
        agencia.setNomeGestor(agenciaDto.getNomeGestor());
        agencia.setEndereco(agenciaDto.getEndereco());
        return agencia;
    }
}
