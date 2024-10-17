package com.finalboss_project.finalboss.insumo.dto;

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
public class InsumoDto {

    private Long id;

    @NotEmpty(message = "El codigoInterno en InsumoDto no puede estar vacío")
    private String codigoInterno;

    @NotEmpty(message = "El nombre en insumoDto no puede estar vacío")
    private String nombre;

    @NotNull(message = "El precioUnitario en InsumoDto no puede ser nulo")
    private Double precioUnitario;

}
