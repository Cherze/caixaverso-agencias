package caixaverso.agencias.dto.mapper;

import caixaverso.agencias.dto.AgenciaDTO;
import caixaverso.agencias.model.Agencia;

public class AgenciaMapper {

    public static Agencia toEntity(AgenciaDTO agenciaDTO) {
        Agencia agencia = new Agencia();
        agencia.setNomeAgencia(agenciaDTO.getNomeAgencia());
        agencia.setDataInauguracao(agenciaDTO.getDataInauguracao());
        agencia.setCgc(agenciaDTO.getCgc());
        agencia.setCep(agenciaDTO.getCep());
        agencia.setNomeGestor(agenciaDTO.getNomeGestor());
        return agencia;
    }
    public static Agencia updateAgencia(AgenciaDTO agenciaDto, Agencia agencia){
        if (agenciaDto == null){
            return null;
        }
        agencia.setCgc(agenciaDto.getCgc());
        agencia.setNomeAgencia(agenciaDto.getNomeAgencia());
        agencia.setNomeGestor(agenciaDto.getNomeGestor());
        agencia.setCep(agenciaDto.getCep());
        agencia.setDataInauguracao(agenciaDto.getDataInauguracao());
        return agencia;
    }

    public static AgenciaDTO toDto(Agencia agencia){
        if (agencia == null){
            return null;
        }
        AgenciaDTO agenciaDto = new AgenciaDTO();
        agenciaDto.setCgc(agencia.getCgc());
        agenciaDto.setNomeAgencia(agencia.getNomeAgencia());
        agenciaDto.setCep(agencia.getCep());
        agenciaDto.setDataInauguracao(agencia.getDataInauguracao());
        agenciaDto.setNomeGestor(agencia.getNomeGestor());
        agenciaDto.setCidade(agencia.getCidade());
        agenciaDto.setEstado(agencia.getEstado());
        return agenciaDto;
    }
}
