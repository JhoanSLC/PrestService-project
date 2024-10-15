package com.finalboss_project.finalboss.aprobacionServicio.dto;

import org.springframework.validation.annotation.Validated;

import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Validated
@AllArgsConstructor
public class AprobacionServicioDto {

  private Long id;

  @NotNull
  private OrdenTrabajo ordenTrabajo;

  @NotNull
  private Persona persona;

  @NotNull
  private Servicio servicio;

  private String hallazgo;
  private String solucion;
}