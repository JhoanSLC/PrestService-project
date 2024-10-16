package com.finalboss_project.finalboss.cuenta.mapper;

import com.finalboss_project.finalboss.cuenta.domain.entity.Cuenta;
import com.finalboss_project.finalboss.cuenta.dto.CuentaDto;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.rol.domain.entity.Rol;

public class CuentaMapper {

    public static CuentaDto toDto(Cuenta entidad){
        return new CuentaDto(
            entidad.getId(),
            entidad.getUsuario(),
            entidad.getContraseña(),
            entidad.getRol().getId(),
            entidad.getPersona().getId()
        );
    }

    public static Cuenta toEntity(CuentaDto dto,Rol rol, Persona persona){
        return new Cuenta(
            dto.getId(),
            dto.getUsuario(),
            dto.getContraseña(),
            rol,
            persona
        );
    }

}
