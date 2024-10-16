package com.finalboss_project.finalboss.cuenta.dto;

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
public class CuentaDto {

    private Long id;

    @NotEmpty
    private String usuario;

    @NotEmpty
    private String contraseña;

    @NotNull
    private Long rolId;

    @NotNull
    private String personaId;

}
