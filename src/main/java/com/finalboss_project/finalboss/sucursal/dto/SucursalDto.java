package com.finalboss_project.finalboss.sucursal.dto;

import java.time.LocalDateTime;

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
public class SucursalDto {
    private Long id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String nit;

    private LocalDateTime fechaCreacion;

    @NotNull
    private Long direccion;

    @NotNull
    private Long empresa;


}
