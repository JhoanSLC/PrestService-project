package com.finalboss_project.finalboss.estadoOrdenTrabajo.mapper;

import com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.entity.EstadoOrdenTrabajo;
import com.finalboss_project.finalboss.estadoOrdenTrabajo.dto.EstadoOrdenTrabajoDto;

public class EstadoOrdenTrabajoMapper {

    public static EstadoOrdenTrabajoDto toDto(EstadoOrdenTrabajo entidad){
        return new EstadoOrdenTrabajoDto(
            entidad.getId(),
            entidad.getNombre()
        );
    }

}
