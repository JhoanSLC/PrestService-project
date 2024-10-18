package com.finalboss_project.finalboss.ordenTrabajo.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.ordenTrabajo.dto.OrdenTrabajoDto;

public interface IOrdenTrabajoService {

    OrdenTrabajoDto create(OrdenTrabajoDto dto);
    OrdenTrabajoDto getById(Long id);
    List<OrdenTrabajoDto> getAll();
    OrdenTrabajoDto update(Long id, OrdenTrabajoDto updatedDto);
    void delete(Long id);

}
