package com.finalboss_project.finalboss.direccion.mapper;

import com.finalboss_project.finalboss.direccion.domain.entity.Direccion;
import com.finalboss_project.finalboss.direccion.dto.DireccionDto;

public class DireccionMapper {

    public static DireccionDto toDto(Direccion entidad){
        return new DireccionDto(
            entidad.getId(),
            entidad.getCalle(),
            entidad.getCarrera(),
            entidad.getDescripcion(),
            entidad.getBarrio(),
            entidad.getCiudad().getId()
        );
    }

    public static Direccion toEntity(DireccionDto dto){
        return new Direccion(
            dto.getId(),
            dto.getCalle(),
            dto.getCarrera(),
            dto.getDescripcion(),
            dto.getBarrio(),
            null
        );
    }

}
