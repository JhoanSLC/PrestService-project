package com.finalboss_project.finalboss.tipoEmail.domain.service;

import java.util.List;
import com.finalboss_project.finalboss.tipoEmail.dto.TipoEmailDto;

public interface ITipoEmailService {

    TipoEmailDto create(TipoEmailDto dto);
    TipoEmailDto getById(Long id);
    List<TipoEmailDto> getAll();
    TipoEmailDto update(Long id, TipoEmailDto updatedDto);
    void delete(Long id);
}
