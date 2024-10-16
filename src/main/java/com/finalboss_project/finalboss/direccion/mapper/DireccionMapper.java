package com.finalboss_project.finalboss.direccion.mapper;

import com.finalboss_project.finalboss.ciudad.domain.entity.Ciudad;
import com.finalboss_project.finalboss.direccion.domain.entity.Direccion;
import com.finalboss_project.finalboss.direccion.dto.DireccionDto;
import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;

public class DireccionMapper {

    public static DireccionDto toDto(Direccion entidad){
        return new DireccionDto(
            entidad.getId(),
            entidad.getCalle(),
            entidad.getCarrera(),
            entidad.getDescripcion(),
            entidad.getBarrio(),
            entidad.getCiudad().getId(),
            entidad.getSucursal().getId()
        );
    }

    public static Direccion toEntity(DireccionDto dto, Ciudad ciudad, Sucursal sucursal){
        return new Direccion(
            dto.getId(),
            dto.getCalle(),
            dto.getCarrera(),
            dto.getDescripcion(),
            dto.getBarrio(),
            ciudad,
            sucursal
        );
    }

}
