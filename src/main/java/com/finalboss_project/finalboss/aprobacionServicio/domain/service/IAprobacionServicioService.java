package com.finalboss_project.finalboss.aprobacionServicio.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.aprobacionServicio.dto.AprobacionServicioDto;

public interface IAprobacionServicioService {

    AprobacionServicioDto create(AprobacionServicioDto dto);
    AprobacionServicioDto getById(Long id);
    List<AprobacionServicioDto> getAll();
    AprobacionServicioDto update(Long id, AprobacionServicioDto updatedDto);
    void delete(Long id);

}
