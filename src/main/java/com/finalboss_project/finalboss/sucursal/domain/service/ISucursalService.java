package com.finalboss_project.finalboss.sucursal.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.sucursal.dto.SucursalDto;

public interface ISucursalService {
    SucursalDto create(SucursalDto dto);
    SucursalDto getById(Long id);
    List<SucursalDto> getAll();
    SucursalDto update(Long id, SucursalDto updatedDto);
    void delete(Long id);
}
