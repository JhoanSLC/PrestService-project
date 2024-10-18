package com.finalboss_project.finalboss.servicio.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.servicio.dto.ServicioDto;

public interface IServicioService {

    ServicioDto create(ServicioDto dto);
    ServicioDto getById(Long id);
    List<ServicioDto> getAll();
    ServicioDto update(Long id, ServicioDto updatedDto);
    void delete(Long id);

}
