package com.finalboss_project.finalboss.ordenTrabajo.mapper;

import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;
import com.finalboss_project.finalboss.ordenTrabajo.dto.OrdenTrabajoDto;

public class OrdenTrabajoMapper {

    public static OrdenTrabajoDto toDto(OrdenTrabajo entidad){
        return new OrdenTrabajoDto(
            entidad.getId(),
            entidad.getNumeroOrdenTrabajo(),
            entidad.getFechaAsignacion(),
            entidad.getHoraAsignacion(),
            entidad.getEmpleado().getId(),
            entidad.getOrdenServicio().getId()
        );
    }

}
