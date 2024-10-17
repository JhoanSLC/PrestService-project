package com.finalboss_project.finalboss.estadoAprobacion.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class EstadoAprobacionDto {

    private Long id;

    @NotEmpty
    private String name;
}
