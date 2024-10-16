package com.finalboss_project.finalboss.direccion.domain.service;

import java.util.List;


import com.finalboss_project.finalboss.direccion.dto.DireccionDto;

public interface IDireccionService {

    DireccionDto create(DireccionDto dto);
    DireccionDto getById(Long id);
    List<DireccionDto> getAll();
    DireccionDto update(Long id, DireccionDto updatedDto);
    void delete(Long id);

}
