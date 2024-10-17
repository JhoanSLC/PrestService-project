package com.finalboss_project.finalboss.estadoOrdenServicio.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class EstadoOrdenServicioDto {

    private Long id;

    @NotEmpty
    private String nombre;

}
