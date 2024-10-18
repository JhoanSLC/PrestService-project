package com.finalboss_project.finalboss.tipoPersona.domain.service;

<<<<<<< HEAD
import com.finalboss_project.finalboss.tipoPersona.domain.entity.TipoPersona;

public class ITipoPersonaService {
    

    TipoPersonaDto create(TipoPersonaDto);
    TipoPersona
=======
import java.util.List;

import com.finalboss_project.finalboss.tipoPersona.dto.TipoPersonaDto;

public interface ITipoPersonaService {
    TipoPersonaDto create(TipoPersonaDto dto);
    TipoPersonaDto getById(Long id);
    List<TipoPersonaDto> getAll();
    TipoPersonaDto update(Long id, TipoPersonaDto updatedDto);
    void delete(Long id);
>>>>>>> bef3bec3a060e28cba40e47a3fe87d6276a5582a
}
