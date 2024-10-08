package com.finalboss_project.finalboss.tipoEmpresa.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.tipoEmpresa.dto.TipoEmpresaDto;

/**
 * Servicio para gestionar operaciones relacionadas con TipoEmpresa.
 * 
 * Define métodos para crear, obtener, actualizar y eliminar 
 * instancias de TipoEmpresaDto.
 */
public interface ITipoEmpresaService {

    TipoEmpresaDto create(TipoEmpresaDto dto);
    TipoEmpresaDto getById(Long id);
    List<TipoEmpresaDto> getAll();
    TipoEmpresaDto update(Long id, TipoEmpresaDto updatedDto);
    void delete(Long id);

}
