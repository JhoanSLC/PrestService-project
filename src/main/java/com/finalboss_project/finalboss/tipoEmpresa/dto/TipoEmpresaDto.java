package com.finalboss_project.finalboss.tipoEmpresa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoEmpresaDto {

    private Long id;
    private String nombre;

    /**
 * DTO (Data Transfer Object) para la entidad TipoEmpresa.
 * 
 * Se utiliza para transferir datos entre la capa de servicio 
 * y la capa de presentación. Contiene:
 * - id: Identificador único de la TipoEmpresa.
 * - descripcion: Descripción del tipo de empresa.
 * 
 * El uso de DTOs ayuda a controlar qué datos se exponen en la API 
 * y facilita la adaptación de la estructura de datos.
 */
}
