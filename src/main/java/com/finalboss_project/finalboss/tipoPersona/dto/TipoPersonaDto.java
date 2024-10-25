package com.finalboss_project.finalboss.tipoPersona.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class TipoPersonaDto {
    private Long id;

    @NotEmpty
    private String nombre;
}
