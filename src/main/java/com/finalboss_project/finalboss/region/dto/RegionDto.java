package com.finalboss_project.finalboss.region.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionDto {

    private Long id;

    @NotEmpty(message = "El nombre de region no puede estar vacío")
    private String nombre;

    @NotNull(message = "El id del país no puede estar vacío")
    private Long paisId;

}
