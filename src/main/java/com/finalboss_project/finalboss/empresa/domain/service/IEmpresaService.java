package com.finalboss_project.finalboss.empresa.domain.service;

import com.finalboss_project.finalboss.empresa.dto.EmpresaDto;

import java.util.List;

public interface IEmpresaService {

    EmpresaDto create(EmpresaDto dto);
    EmpresaDto getById(Long id);
    List<EmpresaDto> getAll();
    EmpresaDto update(Long id, EmpresaDto updatedDto);
    void delete(Long id);

}
