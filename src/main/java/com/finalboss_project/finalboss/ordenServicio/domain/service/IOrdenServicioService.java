package com.finalboss_project.finalboss.ordenServicio.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.ordenServicio.dto.OrdenServicioDto;

public interface IOrdenServicioService {

    OrdenServicioDto create(OrdenServicioDto dto);
    OrdenServicioDto getById(Long id);
    List<OrdenServicioDto> getAll();
    OrdenServicioDto update(Long id, OrdenServicioDto updatedDto);
    void delete(Long id);

}
