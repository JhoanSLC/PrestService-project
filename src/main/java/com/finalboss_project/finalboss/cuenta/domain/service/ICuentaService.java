package com.finalboss_project.finalboss.cuenta.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.cuenta.dto.CuentaDto;

public interface ICuentaService {

    CuentaDto create(CuentaDto dto);
    CuentaDto getById(Long id);
    List<CuentaDto> getAll();
    CuentaDto update(Long id, CuentaDto updatedDto);
    void delete(Long id);
}
