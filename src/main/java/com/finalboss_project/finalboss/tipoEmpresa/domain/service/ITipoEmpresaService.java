package com.finalboss_project.finalboss.tipoEmpresa.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.tipoEmpresa.dto.TipoEmpresaDto;

@Service
public interface ITipoEmpresaService {

    TipoEmpresaDto createTipoEmpresa(TipoEmpresaDto dto);
    TipoEmpresaDto getTipoEmpresaById(Long id);
    List<TipoEmpresaDto> getAllTiposEmpresas();
    TipoEmpresaDto updateTipoEmpresaDto(Long id, TipoEmpresaDto updatedDto);
    void deleteTipoEmpresa(Long id);

}
