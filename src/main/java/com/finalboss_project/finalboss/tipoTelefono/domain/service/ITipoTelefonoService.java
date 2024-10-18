package com.finalboss_project.finalboss.tipoTelefono.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.tipoTelefono.dto.TipoTelefonoDto;

public interface ITipoTelefonoService {

    TipoTelefonoDto create(TipoTelefonoDto dto);
    TipoTelefonoDto getById(Long id);
    List<TipoTelefonoDto> getAll();
    TipoTelefonoDto update(Long id, TipoTelefonoDto updatedDto);
    void delete(Long id);
}
