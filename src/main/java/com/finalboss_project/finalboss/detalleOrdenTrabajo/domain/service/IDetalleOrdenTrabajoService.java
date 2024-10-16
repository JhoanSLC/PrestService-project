package com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.detalleOrdenTrabajo.dto.DetalleOrdenTrabajoDto;

public interface IDetalleOrdenTrabajoService {

    DetalleOrdenTrabajoDto create(DetalleOrdenTrabajoDto dto);
    DetalleOrdenTrabajoDto getById(Long id);
    List<DetalleOrdenTrabajoDto> getAll();
    DetalleOrdenTrabajoDto update(Long id, DetalleOrdenTrabajoDto updatedDto);
    void delete(Long id);
}
