package com.finalboss_project.finalboss.servicio.dto;

import java.sql.Time;

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
public class ServicioDto {
    private Long id;

    @NotEmpty
    private String nombre;

    @NotNull
    private Boolean requiereInsumo;

    private Time tiempoEjecucion;


}
