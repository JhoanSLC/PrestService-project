package com.finalboss_project.finalboss.persona.mapper;

import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.persona.dto.PersonaDto;

public class PersonaMapper {

    public static PersonaDto toDto(Persona persona){
        return new PersonaDto(
            persona.getId(),
            persona.getApellido(),
            persona.getNombre(),
            persona.getFechaRegistro(),
            persona.getSucursal().getId(),
            persona.getTipoPersona().getId()
        );
    }
}
