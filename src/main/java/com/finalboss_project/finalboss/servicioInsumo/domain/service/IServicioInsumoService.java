package com.finalboss_project.finalboss.servicioInsumo.domain.service;

import java.util.List;
import com.finalboss_project.finalboss.servicioInsumo.dto.ServicioInsumoDto;

public interface IServicioInsumoService {
    ServicioInsumoDto create(ServicioInsumoDto dto);
    ServicioInsumoDto getById(Long insumoId, Long servicioId);
    List<ServicioInsumoDto> getAll();
    ServicioInsumoDto update(Long insumoId, Long servicioId, ServicioInsumoDto updatedDto);
    void delete(Long insumoId, Long servicioId);
}
