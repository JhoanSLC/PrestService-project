package com.finalboss_project.finalboss.ciudad.mapper;

import com.finalboss_project.finalboss.ciudad.domain.entity.Ciudad;
import com.finalboss_project.finalboss.ciudad.dto.CiudadDto;
import com.finalboss_project.finalboss.region.domain.entity.Region;

public class CiudadMapper {

    public static CiudadDto toDto(Ciudad entidad){
        return new CiudadDto(
            entidad.getId(),
            entidad.getNombre(),
            entidad.getRegion().getId()
        );
    }

    public static Ciudad toEntidad(CiudadDto dto,Region region){
        return new Ciudad(
            dto.getId(),
            dto.getNombre(),
            region
        );
    }

}
