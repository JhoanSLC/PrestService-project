package com.finalboss_project.finalboss.tipoEmpresa.mapper;

import com.finalboss_project.finalboss.tipoEmpresa.domain.entity.TipoEmpresa;
import com.finalboss_project.finalboss.tipoEmpresa.dto.TipoEmpresaDto;

public class TipoEmpresaMapper {
    
    public static TipoEmpresaDto mapToTipoEmpresaDto(TipoEmpresa entidad){
        return new TipoEmpresaDto(
            entidad.getId(),
            entidad.getDescripcion()
        );
    }

    public static TipoEmpresa mapToTipoEmpresa(TipoEmpresaDto dto){
        return new TipoEmpresa(
            dto.getId(),
            dto.getDescripcion()
        )
    }

}
