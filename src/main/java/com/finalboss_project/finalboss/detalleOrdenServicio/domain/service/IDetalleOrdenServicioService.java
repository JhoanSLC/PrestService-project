package com.finalboss_project.finalboss.detalleOrdenServicio.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.detalleOrdenServicio.dto.DetalleOrdenServicioDto;

public interface IDetalleOrdenServicioService {

    DetalleOrdenServicioDto create(DetalleOrdenServicioDto dto);
    DetalleOrdenServicioDto getById(Long id);
    List<DetalleOrdenServicioDto> getAll();
    DetalleOrdenServicioDto update(Long id, DetalleOrdenServicioDto updatedDto);
    void delete(Long id);
}
