package com.finalboss_project.finalboss.ciudad.dto;

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
public class CiudadDto {

    private Long id;

    @NotEmpty(message = "El nombre de la ciudadDto no puede estar vacía")
    private String nombre;

    @NotNull(message = "El ID de la region en ciudadDto no puede ser nulo")
    private Long regionId;

}
