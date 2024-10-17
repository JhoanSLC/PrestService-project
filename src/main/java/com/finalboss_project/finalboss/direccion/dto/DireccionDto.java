package com.finalboss_project.finalboss.direccion.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class DireccionDto {

    private Long id;

    @NotEmpty(message = "La calle en direccionDto no puede estar vacía")
    private String calle;

    @NotEmpty(message = "La carrera en direccionDto no puede estar vacía")
    private String carrera;

    private String descripcion;

    @NotEmpty(message = "El barrio en direccionDto no puede estar vacío")
    private String barrio;

    @NotNull(message = "El id de ciudad en direccionDto no puede ser nulo")
    private Long ciudadId;

    @NotNull(message = "El id de sucursal en direccionDto no puede ser nulo")
    private Long sucursalId;



}
