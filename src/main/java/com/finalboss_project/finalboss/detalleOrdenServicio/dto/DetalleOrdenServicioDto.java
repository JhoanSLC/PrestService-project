package com.finalboss_project.finalboss.detalleOrdenServicio.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class DetalleOrdenServicioDto {

    private Long id;

    @NotNull
    private Double valorServicio;

    @NotNull
    private Long ordenServicioId;

    @NotNull
    private Long servicioId;

}
