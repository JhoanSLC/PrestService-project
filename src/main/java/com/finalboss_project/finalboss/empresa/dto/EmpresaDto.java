package com.finalboss_project.finalboss.empresa.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;    

@Data
@AllArgsConstructor
@Validated
@NoArgsConstructor
public class EmpresaDto {

    private Long id;

    @NotNull(message = "El nombre no puede ser nulo")
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotNull(message = "El Id del tipo de empresa no puede ser nulo")
    private Long tipoEmpresaId;

}
