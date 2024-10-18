package com.finalboss_project.finalboss.empresaServicio.mapper;

import com.finalboss_project.finalboss.empresaServicio.domain.entity.EmpresaServicio;
import com.finalboss_project.finalboss.empresaServicio.dto.EmpresaServicioDto;
import com.finalboss_project.finalboss.empresaServicio.domain.entity.EmpresaServicioPk;

public class EmpresaServicioMapper {

    public static EmpresaServicioDto toDto(EmpresaServicio entidad) {
        return new EmpresaServicioDto(
            entidad.getId().getSucursalId(),
            entidad.getId().getServicioId(),
            entidad.getValorServicio()
        );
    }

    public static EmpresaServicio toEntity(EmpresaServicioDto dto) {
        return new EmpresaServicio(
            new EmpresaServicioPk(dto.getSucursalId(), dto.getServicioId()),
            dto.getValorServicio(),
            null, 
            null  
        );
    }
}
