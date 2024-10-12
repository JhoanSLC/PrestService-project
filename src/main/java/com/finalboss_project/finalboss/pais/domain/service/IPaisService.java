package com.finalboss_project.finalboss.pais.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.pais.dto.PaisDto;

public interface IPaisService {

    PaisDto create(PaisDto dto);
    PaisDto getById(Long id);
    List<PaisDto> getAll();
    PaisDto update(Long id, PaisDto updatedDto);
    void delete(Long id);

}
