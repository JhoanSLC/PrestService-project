package com.finalboss_project.finalboss.sucursal.mapper;

import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;
import com.finalboss_project.finalboss.sucursal.dto.SucursalDto;

public class SucursalMapper {

    public static SucursalDto toDto(Sucursal entidad){
        return new SucursalDto(
            entidad.getId(),
            entidad.getNombre(),
            entidad.getNit(),
            entidad.getFechaCreacion(),
            entidad.getDireccion().getId(),
            entidad.getEmpresa().getId()
        );
    }
}
