package com.finalboss_project.finalboss.personaInsumo.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.personaInsumo.dto.PersonaInsumoDto;

public interface IPersonaInsumoService {

    PersonaInsumoDto create(PersonaInsumoDto dto);
    PersonaInsumoDto getById(String personaId, Long insumoId);
    List<PersonaInsumoDto> getAll();
    PersonaInsumoDto update(String personaId, Long insumoId, PersonaInsumoDto updatedDto);
    void delete(String personaId, Long insumoId);
}
