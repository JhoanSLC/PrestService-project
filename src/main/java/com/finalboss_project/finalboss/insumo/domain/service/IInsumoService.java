package com.finalboss_project.finalboss.insumo.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.insumo.dto.InsumoDto;

public interface IInsumoService {

    InsumoDto create(InsumoDto dto);
    InsumoDto getById(Long id);
    List<InsumoDto> getAll();
    InsumoDto update(Long id, InsumoDto updatedDto);
    void delete(Long id);

}
