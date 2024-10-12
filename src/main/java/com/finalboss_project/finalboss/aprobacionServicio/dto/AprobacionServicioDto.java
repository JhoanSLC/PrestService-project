package com.finalBoss


@Data
@NoArgsConstructor
@Validated
@AllArgsConstructor
public class AprobacionServicioDto(){
  
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