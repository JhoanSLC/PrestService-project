package com.finalboss_project.finalboss.region.mapper;

import com.finalboss_project.finalboss.pais.mapper.PaisMapper;
import com.finalboss_project.finalboss.region.domain.entity.Region;
import com.finalboss_project.finalboss.region.dto.RegionDto;

public class RegionMapper {

    public static RegionDto toDto(Region entidad){
        return new RegionDto(
            entidad.getId(),
            entidad.getNombre(),
            PaisMapper.toDto(entidad.getPais())
        );
    }

    public static Region toRegion(RegionDto dto){
        return new Region(
            dto.getId(),
            dto.getNombre(),
            PaisMapper.toEntity(dto.getPaisDto())
        );
    }

}
