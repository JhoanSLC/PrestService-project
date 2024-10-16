package com.finalboss_project.finalboss.tipoTelefono.mapper;

import com.finalboss_project.finalboss.tipoTelefono.domain.entity.TipoTelefono;
import com.finalboss_project.finalboss.tipoTelefono.dto.TipoTelefonoDto;

public class TipoTelefonoMapper {
    
    public static TipoTelefonoDto toDto(TipoTelefono TipoTelefono) {
        return new TipoTelefonoDto(
            TipoTelefono.getId(),
            TipoTelefono.getNombre()
        );
    
    }

    public static TipoTelefono toEntity(TipoTelefonoDto dto){
        return new TipoTelefono(
            dto.getId(),
            dto.getNombre()
        );
    }

}
