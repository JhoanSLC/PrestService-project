package com.finalboss_project.finalboss.region.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.region.dto.RegionDto;

public interface IRegionService {

    RegionDto create(RegionDto dto);
    RegionDto getById(Long id);
    List<RegionDto> getAll();
    RegionDto update(Long id, RegionDto updatedDto);
    void delete(Long id);

}
