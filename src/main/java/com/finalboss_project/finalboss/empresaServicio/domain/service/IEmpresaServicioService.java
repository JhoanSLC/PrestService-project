package com.finalboss_project.finalboss.empresaServicio.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.empresaServicio.dto.EmpresaServicioDto;

public interface IEmpresaServicioService {

    EmpresaServicioDto create(EmpresaServicioDto dto);
    EmpresaServicioDto getById(Long sucursalId, Long servicioId);
    List<EmpresaServicioDto> getAll();
    EmpresaServicioDto update(Long sucursalId, Long servicioId, EmpresaServicioDto updatedDto);
    void delete(Long sucursalId, Long servicioId);
}
