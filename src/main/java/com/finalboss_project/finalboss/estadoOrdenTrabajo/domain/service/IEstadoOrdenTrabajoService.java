package com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.estadoOrdenTrabajo.dto.EstadoOrdenTrabajoDto;

public interface IEstadoOrdenTrabajoService {

    EstadoOrdenTrabajoDto create(EstadoOrdenTrabajoDto dto);
    EstadoOrdenTrabajoDto getById(Long id);
    List<EstadoOrdenTrabajoDto> getAll();
    EstadoOrdenTrabajoDto update(Long id, EstadoOrdenTrabajoDto updatedDto);
    void delete(Long id);

}
