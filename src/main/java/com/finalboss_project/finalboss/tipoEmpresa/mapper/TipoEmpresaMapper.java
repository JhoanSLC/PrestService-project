package com.finalboss_project.finalboss.tipoEmpresa.mapper;

import com.finalboss_project.finalboss.tipoEmpresa.domain.entity.TipoEmpresa;
import com.finalboss_project.finalboss.tipoEmpresa.dto.TipoEmpresaDto;


/**
 * Este Mapper se utiliza para facilitar la conversión entre la entidad 
 * TipoEmpresa (que representa la tabla en la base de datos) y su 
 * correspondiente DTO (Data Transfer Object), que es la representación 
 * lógica de los datos en la aplicación.
 *
 * La separación de las entidades y los DTOs permite un mejor control 
 * sobre los datos que se exponen y se manejan, lo que facilita 
 * el mantenimiento y la evolución de la aplicación. 
 * 
 * Métodos:
 * - mapToTipoEmpresaDto: Convierte una entidad TipoEmpresa en un 
 *   TipoEmpresaDto.
 * - mapToTipoEmpresa: Convierte un TipoEmpresaDto en una entidad 
 *   TipoEmpresa.
 */
public class TipoEmpresaMapper {
    
    public static TipoEmpresaDto mapToTipoEmpresaDto(TipoEmpresa entidad){
        return new TipoEmpresaDto(
            entidad.getId(),
            entidad.getDescripcion()
        );
    }

    public static TipoEmpresa mapToTipoEmpresa(TipoEmpresaDto dto){
        return new TipoEmpresa(
            dto.getId(),
            dto.getDescripcion()
        )
    }

}
