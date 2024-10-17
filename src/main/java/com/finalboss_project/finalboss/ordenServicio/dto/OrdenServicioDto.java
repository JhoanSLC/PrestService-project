package com.finalboss_project.finalboss.ordenServicio.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class OrdenServicioDto {

    private Long id;

    private Date fechaOrden;

    @NotEmpty(message = "El ID del cliente en OrdenServicioDto no puede estar vacío")
    private String clienteId;

    @NotEmpty(message = "El ID del empleado en OrdenServicioDto no puede estar vacío")
    private String empleadoId;

    @NotNull(message = "El ID del estadoOrdenServicio en ordenServicioDto no puede ser nulo")
    private Long estadoOrdenServicioId;

}
