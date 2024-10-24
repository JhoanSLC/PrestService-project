package com.finalboss_project.finalboss.telPersona.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class TelPersonaDto {
    
    private Long id;

    @NotNull
    private Long numero;

    @NotNull
    private Long tipoTelefonoId;

    @NotEmpty
    private String personaId;
}
