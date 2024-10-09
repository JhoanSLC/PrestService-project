package com.finalboss_project.finalboss.empresa.mapper;

import com.finalboss_project.finalboss.empresa.domain.entity.Empresa;
import com.finalboss_project.finalboss.empresa.dto.EmpresaDto;
import com.finalboss_project.finalboss.tipoEmpresa.mapper.TipoEmpresaMapper;

public class EmpresaMapper {

    public static EmpresaDto toEmpresaDto(Empresa entidad){
        return new EmpresaDto(
            entidad.getId(),
            entidad.getNombre(),
            TipoEmpresaMapper.mapToTipoEmpresaDto(entidad.getTipoEmpresa())
        );
    }

    public static Empresa toEmpresa(EmpresaDto dto){
        return new Empresa(
            dto.getId(),
            dto.getNombre(),
            TipoEmpresaMapper.mapToTipoEmpresa(dto.getTipoEmpresaDto())
        );
    }

}
