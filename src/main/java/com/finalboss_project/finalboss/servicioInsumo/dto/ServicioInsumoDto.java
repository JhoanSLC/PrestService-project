package com.finalboss_project.finalboss.servicioInsumo.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ServicioInsumoDto {

    private Long insumoId;
    private Long servicioId;

    @NotNull(message = "El valor unitario no puede ser nulo")
    private Double valorUnitario;
    private Integer stock;
    private Integer stockMin;
    private Integer stockMax;

}
