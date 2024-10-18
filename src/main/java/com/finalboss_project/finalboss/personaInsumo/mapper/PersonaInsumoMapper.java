package com.finalboss_project.finalboss.personaInsumo.mapper;

import com.finalboss_project.finalboss.personaInsumo.domain.entity.PersonaInsumo;
import com.finalboss_project.finalboss.personaInsumo.dto.PersonaInsumoDto;
import com.finalboss_project.finalboss.personaInsumo.domain.entity.PersonaInsumoPk;

public class PersonaInsumoMapper {

    public static PersonaInsumoDto toDto(PersonaInsumo entidad) {
        return new PersonaInsumoDto(
            entidad.getId().getPersonaId(),
            entidad.getId().getInsumoId(),
            entidad.getServicio().getId() // Suponiendo que Servicio tiene un método getId()
        );
    }

    public static PersonaInsumo toEntity(PersonaInsumoDto dto) {
        return new PersonaInsumo(
            new PersonaInsumoPk(dto.getPersonaId(), dto.getInsumoId()),
            null,
            null, 
            null  
        );
    }
}
