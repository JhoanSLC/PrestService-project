package com.finalboss_project.finalboss.empresaServicio.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaServicioDto {

    @NotNull
    private Long sucursalId;

    @NotNull
    private Long servicioId;

    @NotNull
    private Double valorServicio;
}
