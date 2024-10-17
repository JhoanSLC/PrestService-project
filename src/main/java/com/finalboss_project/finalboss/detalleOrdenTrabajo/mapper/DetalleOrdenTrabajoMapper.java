package com.finalboss_project.finalboss.detalleOrdenTrabajo.mapper;

import com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.entity.DetalleOrdenTrabajo;
import com.finalboss_project.finalboss.detalleOrdenTrabajo.dto.DetalleOrdenTrabajoDto;
import com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.entity.EstadoOrdenTrabajo;
import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;

public class DetalleOrdenTrabajoMapper {

    public static DetalleOrdenTrabajoDto toDto(DetalleOrdenTrabajo entidad){
        return new DetalleOrdenTrabajoDto(
            entidad.getId(),
            entidad.getOrdenTrabajo().getId(),
            entidad.getServicio().getId(),
            entidad.getFecha(),
            entidad.getEstadoOrdenTrabajo().getId()
        );
    }

    public static DetalleOrdenTrabajo toEntity(DetalleOrdenTrabajoDto dto, OrdenTrabajo ordenTrabajo, Servicio servicio, EstadoOrdenTrabajo estado){
        return new DetalleOrdenTrabajo(
            dto.getId(),
            ordenTrabajo,
            servicio,
            dto.getFecha(),
            estado
        );
    }

}
