package com.finalboss_project.finalboss.estadoAprobacion.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.estadoAprobacion.dto.EstadoAprobacionDto;


public interface IEstadoAprobacionService {

    EstadoAprobacionDto create(EstadoAprobacionDto dto);
    EstadoAprobacionDto getById(Long id);
    List<EstadoAprobacionDto> getAll();
    EstadoAprobacionDto update(Long id, EstadoAprobacionDto updatedDto);
    void delete(Long id);

}
