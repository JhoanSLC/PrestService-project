package com.finalboss_project.finalboss.region.mapper;

import com.finalboss_project.finalboss.region.domain.entity.Region;
import com.finalboss_project.finalboss.region.dto.RegionDto;

public class RegionMapper {

    public static RegionDto toDto(Region entidad){
        return new RegionDto(
            entidad.getId(),
            entidad.getNombre(),
            entidad.getPais().getId()
        );
    }

    public static Region toRegion(RegionDto dto){
        return new Region(
            dto.getId(),
            dto.getNombre(),
            null
        );
    }

}
