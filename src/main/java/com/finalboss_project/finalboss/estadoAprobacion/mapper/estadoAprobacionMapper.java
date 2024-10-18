package com.finalboss_project.finalboss.estadoAprobacion.mapper;

import com.finalboss_project.finalboss.estadoAprobacion.domain.entity.EstadoAprobacion;
import com.finalboss_project.finalboss.estadoAprobacion.dto.EstadoAprobacionDto;

public class EstadoAprobacionMapper {

    public static EstadoAprobacionDto toDto(EstadoAprobacion entidad){
        return new EstadoAprobacionDto(
            entidad.getId(),
            entidad.getNombre()
        );
    }

}
