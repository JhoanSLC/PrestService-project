package com.finalboss_project.finalboss.pais.mapper;

import com.finalboss_project.finalboss.pais.domain.entity.Pais;
import com.finalboss_project.finalboss.pais.dto.PaisDto;

public class PaisMapper {

    public static PaisDto toDto(Pais pais){
        return new PaisDto(
            pais.getId(),
            pais.getNombre()
        );
    }

    public static Pais toEntity(PaisDto dto){
        return new Pais(
            dto.getId(),
            dto.getNombre()
        );
    }

}
