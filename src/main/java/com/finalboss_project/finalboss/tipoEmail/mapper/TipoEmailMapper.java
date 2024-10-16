package com.finalboss_project.finalboss.tipoEmail.mapper;

import com.finalboss_project.finalboss.tipoEmail.domain.entity.TipoEmail;
import com.finalboss_project.finalboss.tipoEmail.dto.TipoEmailDto;

public class TipoEmailMapper {

    public static TipoEmailDto toDto(TipoEmail tipoEmail){
        return new TipoEmailDto(
            tipoEmail.getId(),
            tipoEmail.getNombre()
        );
    }
    
    public static TipoEmail toEntity(TipoEmailDto dto){
        return new TipoEmail(
            dto.getId(),
            dto.getNombre()
        );
    }
}
