package com.finalboss_project.finalboss.tipoPersona.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.tipoPersona.dto.TipoPersonaDto;

public interface ITipoPersonaService {
    TipoPersonaDto create(TipoPersonaDto dto);
    TipoPersonaDto getById(Long id);
    List<TipoPersonaDto> getAll();
    TipoPersonaDto update(Long id, TipoPersonaDto updatedDto);
    void delete(Long id);
}
