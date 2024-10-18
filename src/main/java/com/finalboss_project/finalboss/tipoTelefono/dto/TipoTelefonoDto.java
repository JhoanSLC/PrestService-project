package com.finalboss_project.finalboss.tipoTelefono.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class TipoTelefonoDto {
    
    private long id;

    @NotEmpty
    private String nombre;

}
