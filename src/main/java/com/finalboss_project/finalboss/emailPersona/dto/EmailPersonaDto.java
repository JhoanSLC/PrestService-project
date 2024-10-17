package com.finalboss_project.finalboss.emailPersona.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class EmailPersonaDto {

    private Long id;

    @NotEmpty(message = "El email en emailPersonaDto no puede estar vacío")
    private String email;

    @NotEmpty(message = "El ID de la persona en emailPersona no puede estar vacío")
    private String personaId;

    @NotNull(message = "El ID del tipoEmail no puede ser nulo")
    private Long tipoEmailId;
}   
