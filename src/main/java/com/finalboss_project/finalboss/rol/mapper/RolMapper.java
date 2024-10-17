package com.finalboss_project.finalboss.rol.mapper;

import com.finalboss_project.finalboss.rol.domain.entity.Rol;
import com.finalboss_project.finalboss.rol.dto.RolDto;

public class RolMapper {
    public static RolDto toDto(Rol rol){
        return new RolDto(
            rol.getId(),
            rol.getNombre()
        );
    }
}
