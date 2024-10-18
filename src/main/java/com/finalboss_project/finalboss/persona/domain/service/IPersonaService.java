package com.finalboss_project.finalboss.persona.domain.service;

import java.util.List;
import com.finalboss_project.finalboss.persona.dto.PersonaDto;

public interface IPersonaService {

    PersonaDto create(PersonaDto dto);
    PersonaDto getById(Long id);
    List<PersonaDto> getAll();
    PersonaDto update(Long id, PersonaDto updatedDto);
    void delete(Long id);

}
