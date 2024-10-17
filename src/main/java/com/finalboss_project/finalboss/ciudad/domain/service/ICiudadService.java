package com.finalboss_project.finalboss.ciudad.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.ciudad.dto.CiudadDto;


public interface ICiudadService {

    CiudadDto create(CiudadDto dto);
    CiudadDto getById(Long id);
    List<CiudadDto> getAll();
    CiudadDto update(Long id, CiudadDto updatedDto);
    void delete(Long id);

}
