package com.finalboss_project.finalboss.estadoOrdenServicio.mapper;

import com.finalboss_project.finalboss.estadoOrdenServicio.domain.entity.EstadoOrdenServicio;
import com.finalboss_project.finalboss.estadoOrdenServicio.dto.EstadoOrdenServicioDto;

public class EstadoOrdenServicioMapper {

    public static EstadoOrdenServicioDto toDto(EstadoOrdenServicio entidad){
        return new EstadoOrdenServicioDto(
            entidad.getId(),
            entidad.getNombre()
        );
    }

}
