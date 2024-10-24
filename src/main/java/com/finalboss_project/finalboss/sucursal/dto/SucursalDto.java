package com.finalboss_project.finalboss.sucursal.dto;

import java.sql.Date;

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
public class SucursalDto {
    
    private Long id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String nit;

    private Date fechaCreacion;

    @NotNull
    private Long direccionId;

    @NotNull
    private Long empresaId;


}
