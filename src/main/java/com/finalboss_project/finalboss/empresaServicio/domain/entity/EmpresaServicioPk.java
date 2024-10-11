package com.finalboss_project.finalboss.empresaServicio.domain.entity;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class EmpresaServicioPk {

    @Column(name = "sucursalId")
    @NotNull(message = "El ID de la sucursal no puede ser nulo")
    private Long sucursalId;

    @Column(name = "servicioId")
    @NotNull(message = "El ID del servicio no puede ser nulo")
    private Long servicioId;

}
