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

     private LocalDateTime fechaRegistro;
    
     @NotNull
     private Long sucursal;

     @NotNull
     private Long tipoPersona;
}
