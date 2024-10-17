package com.finalboss_project.finalboss.aprobacionServicio.dto;



import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AprobacionServicioDto {

	private Long id;

	@NotNull
	private Long ordenTrabajoId;

	@NotNull
	private String personaId;

	@NotNull
	private Long servicioId;

	private String hallazgo;
	private String solucion;

	@NotNull
	private Long estadoAprobacionId;
}