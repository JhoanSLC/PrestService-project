package com.finalboss_project.finalboss.detalleOrdenTrabajo.dto;

import java.sql.Date;

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

    private Date fecha;

    @NotNull
    private Long estadoOrdenTrabajoId;
}
