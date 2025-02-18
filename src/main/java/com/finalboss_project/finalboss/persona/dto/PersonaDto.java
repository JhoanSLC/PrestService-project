package com.finalboss_project.finalboss.persona.dto;

import java.time.LocalDateTime;

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
public class PersonaDto {

    private String id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    private String usuario;

    @NotEmpty
    private String contraseña;

    private LocalDateTime fechaRegistro;

    private Long sucursalId;

    @NotNull(message = "El tipoPersonaId en PersonaDto no puede ser nulo")
    private Long tipoPersonaId;

}