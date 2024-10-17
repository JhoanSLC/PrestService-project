package com.finalboss_project.finalboss.ciudad.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.ciudad.dto.EstadoAprobacionDto;


public interface ICiudadService {

    EstadoAprobacionDto create(EstadoAprobacionDto dto);
    EstadoAprobacionDto getById(Long id);
    List<EstadoAprobacionDto> getAll();
    EstadoAprobacionDto update(Long id, EstadoAprobacionDto updatedDto);
    void delete(Long id);

}
