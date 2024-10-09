package com.finalboss_project.finalboss.empresa.dto;

import com.finalboss_project.finalboss.tipoEmpresa.dto.TipoEmpresaDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {

    private Long id;
    private String nombre;
    private TipoEmpresaDto tipoEmpresaDto;

}
