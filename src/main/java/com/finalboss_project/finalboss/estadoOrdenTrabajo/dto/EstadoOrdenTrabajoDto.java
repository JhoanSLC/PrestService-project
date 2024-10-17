package com.finalboss_project.finalboss.estadoOrdenTrabajo.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class EstadoOrdenTrabajoDto {

    private Long id;

    @NotEmpty(message = "El nombre en EstadoOrdenTrabajoDto no puede estar vacío")
    private String nombre;

}
