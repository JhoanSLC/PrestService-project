package com.finalboss_project.finalboss.telPersona.mappper;

import com.finalboss_project.finalboss.telPersona.domain.entity.TelPersona;
import com.finalboss_project.finalboss.telPersona.dto.TelPersonaDto;

public class TelPersonaMapper {

    public static TelPersonaDto toDto(TelPersona telPersona){
        return new TelPersonaDto(
            telPersona.getId(),
            telPersona.getNumero(),
            telPersona.getTipoTelefono().getId(),
            telPersona.getPersona().getId()
        );
    }
}
