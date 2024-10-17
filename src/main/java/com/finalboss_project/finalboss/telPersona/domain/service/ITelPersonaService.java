package com.finalboss_project.finalboss.telPersona.domain.service;

import java.util.List;
import com.finalboss_project.finalboss.telPersona.dto.TelPersonaDto;

public class ITelPersonaService {
    TelPersonaDto create(TelPersonaDto dto);
    TelPersonaDto getById(Long id);
    List<TelPersonaDto> getAll();
    TelPersonaDto update(Long id, TelPersonaDto updatedDto);
    void delete(Long id);
}
