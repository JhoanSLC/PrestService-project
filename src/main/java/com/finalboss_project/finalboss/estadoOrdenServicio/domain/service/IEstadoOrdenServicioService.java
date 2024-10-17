package com.finalboss_project.finalboss.estadoOrdenServicio.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.estadoOrdenServicio.dto.EstadoOrdenServicioDto;

public interface IEstadoOrdenServicioService {

    EstadoOrdenServicioDto create(EstadoOrdenServicioDto dto);
    EstadoOrdenServicioDto getById(Long id);
    List<EstadoOrdenServicioDto> getAll();
    EstadoOrdenServicioDto update(Long id, EstadoOrdenServicioDto updatedDto);
    void delete(Long id);

}
