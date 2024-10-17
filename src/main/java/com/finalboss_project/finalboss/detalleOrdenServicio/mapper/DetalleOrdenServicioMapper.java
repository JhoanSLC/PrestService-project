package com.finalboss_project.finalboss.detalleOrdenServicio.mapper;

import com.finalboss_project.finalboss.detalleOrdenServicio.domain.entity.DetalleOrdenServicio;
import com.finalboss_project.finalboss.detalleOrdenServicio.dto.DetalleOrdenServicioDto;
import com.finalboss_project.finalboss.ordenServicio.domain.entity.OrdenServicio;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;

public class DetalleOrdenServicioMapper {

    public static DetalleOrdenServicioDto toDto(DetalleOrdenServicio entidad){
        return new DetalleOrdenServicioDto(
            entidad.getId(),
            entidad.getValorServicio(),
            entidad.getOrdenServicio().getId(),
            entidad.getServicio().getId()
        );
    }

    public static DetalleOrdenServicio toEntity(DetalleOrdenServicioDto dto,OrdenServicio orden, Servicio servicio){
        return new DetalleOrdenServicio(
            dto.getId(),
            dto.getValorServicio(),
            orden,
            servicio
        );
    }

}
