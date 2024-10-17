package com.finalboss_project.finalboss.ordenServicio.mapper;

import com.finalboss_project.finalboss.ordenServicio.domain.entity.OrdenServicio;
import com.finalboss_project.finalboss.ordenServicio.dto.OrdenServicioDto;

public class OrdenServicioMapper {

    public static OrdenServicioDto toDto(OrdenServicio entidad){
        return new OrdenServicioDto(
            entidad.getId(),
            entidad.getFechaOrden(),
            entidad.getCliente().getId(),
            entidad.getEmpleado().getId(),
            entidad.getEstadoOrdenServicio().getId()
        );
    }
}
