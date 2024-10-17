package com.finalboss_project.finalboss.ordenTrabajo.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class OrdenTrabajoDto {

    private Long id;

    private String numeroOrdentrabajo;

    private Date fechaAsignacion;

    private Time horaAsignacion;

    @NotNull(message = "El ID del empleado en OrdenTrabajoDto no puede ser nulo")
    private String empleadoId;

    @NotNull(message = "El ID de ordenServicio en OrdenTrabajoDto no puede ser nulo")
    private Long ordenServicioId;

}
