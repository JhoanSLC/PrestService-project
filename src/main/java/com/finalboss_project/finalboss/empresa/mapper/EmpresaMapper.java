package com.finalboss_project.finalboss.empresa.mapper;

import com.finalboss_project.finalboss.empresa.domain.entity.Empresa;
import com.finalboss_project.finalboss.empresa.dto.EmpresaDto;

public class EmpresaMapper {

    public static EmpresaDto toEmpresaDto(Empresa entidad){
        return new EmpresaDto(
            entidad.getId(),
            entidad.getNombre(),
            entidad.getTipoEmpresa().getId()
        );
    }

    public static Empresa toEmpresa(EmpresaDto dto){

        return new Empresa(
            dto.getId(),
            dto.getNombre(),
            null
            
        );
    }

}
