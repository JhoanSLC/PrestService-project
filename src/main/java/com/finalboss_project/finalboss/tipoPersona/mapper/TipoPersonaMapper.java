package com.finalboss_project.finalboss.tipoPersona.mapper;

import com.finalboss_project.finalboss.tipoPersona.domain.entity.TipoPersona;
import com.finalboss_project.finalboss.tipoPersona.dto.TipoPersonaDto;

public class TipoPersonaMapper {
    
    public static TipoPersonaDto toDto(TipoPersona tipoPersona) {
        return new TipoPersonaDto(
            tipoPersona.getId(),
            tipoPersona.getNombre()
        );
    }

    public static TipoPersona toEntity(TipoPersonaDto dto){
        return new TipoPersona(
            dto.getId(),
            dto.getNombre()
        );
    }

}


