package com.finalboss_project.finalboss.persona.mapper;

import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.persona.dto.PersonaDto;

public class PersonaMapper {

    public static PersonaDto toDto(Persona persona){
        return new PersonaDto(
            persona.getId(),
            persona.getApellido(),
            persona.getNombre(),
            persona.getTipoPersona().getId(),
            persona.getGenero().getId(),
            persona.getFechaNacimiento(),
            persona.getTipoDocumento().getId(),
            persona.getDocumento(),
            persona.getDireccion(),
            persona.getTelefono(),
            persona.getEmail()
        );
    }
}
