package com.finalboss_project.finalboss.aprobacionServicio.mapper;

import com.finalboss_project.finalboss.aprobacionServicio.domain.entity.AprobacionServicio;
import com.finalboss_project.finalboss.aprobacionServicio.dto.AprobacionServicioDto;
import com.finalboss_project.finalboss.estadoAprobacion.domain.entity.EstadoAprobacion;
import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;

public class AprobacionServicioMapper {

    public static AprobacionServicioDto toDto(AprobacionServicio entidad){
        return new AprobacionServicioDto(
            entidad.getId(),
            entidad.getOrdenTrabajo().getId(),
            entidad.getPersona().getId(),
            entidad.getServicio().getId(),
            entidad.getHallazgo(),
            entidad.getSolucion(),
            entidad.getEstadoAprobacion().getId()
        );
    }

    public static AprobacionServicio toEntity(AprobacionServicioDto dto, OrdenTrabajo ordenTrabajo, Persona persona, Servicio servicio, EstadoAprobacion estado){
        return new AprobacionServicio(
            dto.getId(),
            ordenTrabajo,
            persona,
            servicio,
            dto.getHallazgo(),
            dto.getSolucion(),
            estado
        );
    }

}
