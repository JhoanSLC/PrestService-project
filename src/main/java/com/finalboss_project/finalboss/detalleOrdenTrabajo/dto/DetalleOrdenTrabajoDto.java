package com.finalboss_project.finalboss.detalleOrdenTrabajo.dto;

import java.time.LocalDateTime;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class DetalleOrdenTrabajoDto {

    private Long id;

    @NotNull
    private Long ordenTrabajoId;

    @NotNull
    private Long servicioId;

    private LocalDateTime fecha;

    @NotNull
    private Long estadoOrdenTrabajoId;
}
