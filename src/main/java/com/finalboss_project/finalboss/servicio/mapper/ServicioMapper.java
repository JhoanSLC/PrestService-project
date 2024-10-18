package com.finalboss_project.finalboss.servicio.mapper;

import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;
import com.finalboss_project.finalboss.servicio.dto.ServicioDto;

public class ServicioMapper {

    public static ServicioDto toDto(Servicio servicio){
        return new ServicioDto(
            servicio.getId(),
            servicio.getNombre(),
            servicio.getRequiereInsumo(),
            servicio.getTiempoEjecucion()
        );
    }

    public static Servicio toEntity(ServicioDto dto){
        return new Servicio(
            dto.getId(),
            dto.getNombre(),
            dto.getRequiereInsumo(),
            dto.getTiempoEjecucion()
        );
    }
}
