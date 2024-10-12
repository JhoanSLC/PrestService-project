package com.finalboss_project.finalboss.aprobacionServicio.domain.entity;

import org.springframework.validation.annotation.Validated;

import com.finalboss_project.finalboss.estadoAprobacion.domain.entity.EstadoAprobacion;
import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name = "aprobacionServicio")
public class AprobacionServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ordenTrabajoId",nullable = false)
    @NotNull
    private OrdenTrabajo ordenTrabajo;

    @ManyToOne
    @JoinColumn(name = "clienteId",nullable = false)
    @NotNull
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "servicioId",nullable = false)
    @NotNull
    private Servicio servicio;

    private String hallazgo;
    private String solucion;

    @ManyToOne
    @JoinColumn(name = "estadoAprobacionId",nullable = false)
    @NotNull
    private EstadoAprobacion estadoAprobacion;

}
