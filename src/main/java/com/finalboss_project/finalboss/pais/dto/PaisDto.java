package com.finalboss_project.finalboss.pais.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class PaisDto {

    private Long id;
    
    @NotEmpty
    private String nombre;

}
