package com.finalboss_project.finalboss.region.dto;

import com.finalboss_project.finalboss.pais.dto.PaisDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionDto {

    private Long id;
    private String nombre;
    private PaisDto paisDto;

}
