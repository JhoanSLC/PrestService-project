package com.finalboss_project.finalboss.emailPersona.mapper;

import com.finalboss_project.finalboss.emailPersona.domain.entity.EmailPersona;
import com.finalboss_project.finalboss.emailPersona.dto.EmailPersonaDto;

public class EmailPersonaMapper {

    public static EmailPersonaDto toDto(EmailPersona entidad){
        return new EmailPersonaDto(
            entidad.getId(),
            entidad.getEmail(),
            entidad.getPersona().getId(),
            entidad.getTipoEmail().getId()
        );
    }

}
