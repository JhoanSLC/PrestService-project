package com.finalboss_project.finalboss.insumo.mapper;

import com.finalboss_project.finalboss.insumo.domain.entity.Insumo;
import com.finalboss_project.finalboss.insumo.dto.InsumoDto;

public class InsumoMapper {

    public static InsumoDto toDto(Insumo entidad){
        return new InsumoDto(
            entidad.getId(),
            entidad.getCodigoInterno(),
            entidad.getNombre(),
            entidad.getPrecioUnitario()
        );
    }

    public static Insumo toEntity(InsumoDto dto){
        return new Insumo(
            dto.getId(),
            dto.getCodigoInterno(),
            dto.getNombre(),
            dto.getPrecioUnitario()
        );
    }

}
