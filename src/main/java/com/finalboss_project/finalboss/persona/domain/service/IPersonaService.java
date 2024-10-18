package com.finalboss_project.finalboss.persona.domain.service;

import java.util.List;
import com.finalboss_project.finalboss.persona.dto.PersonaDto;

public interface IPersonaService {

    PersonaDto create(PersonaDto dto);
    PersonaDto getById(String id);
    List<PersonaDto> getAll();
    PersonaDto update(String id, PersonaDto updatedDto);
    void delete(String id);

}
