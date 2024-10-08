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

    TipoEmpresaDto createTipoEmpresa(TipoEmpresaDto dto);
    TipoEmpresaDto getTipoEmpresaById(Long id);
    List<TipoEmpresaDto> getAllTiposEmpresas();
    TipoEmpresaDto updateTipoEmpresaDto(Long id, TipoEmpresaDto updatedDto);
    void deleteTipoEmpresa(Long id);

}
