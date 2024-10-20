package com.finalboss_project.finalboss.persona.mapper;

import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.persona.dto.PersonaDto;

public class PersonaMapper {

    public static PersonaDto toDto(Persona dto){
        if (dto.getSucursal() != null){
            return new PersonaDto(
                dto.getId(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getUsuario(),
                dto.getContraseña(),
                dto.getFechaRegistro(),
                dto.getSucursal().getId(),
                dto.getTipoPersona().getId()
            );
        } else {
            return new PersonaDto(
            dto.getId(),
            dto.getNombre(),
            dto.getApellido(),
            dto.getUsuario(),
            dto.getContraseña(),
            dto.getFechaRegistro(),
            null,
            dto.getTipoPersona().getId()
        );
        }
        
    }

}