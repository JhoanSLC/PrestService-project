package com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.entity;

import org.springframework.validation.annotation.Validated;

import com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.entity.EstadoOrdenTrabajo;
import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name = "detalleOrdenTrabajo")
public class DetalleOrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ordenTrabajoId",nullable = false)
    @NotNull
    private OrdenTrabajo ordenTrabajo;

    @ManyToOne
    @JoinColumn(name = "servicioAsignadoId",nullable = false)
    @NotNull
    private Servicio servicio;

    @Column
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "estadoOrdenTrabajoId",nullable = false)
    @NotNull
    private EstadoOrdenTrabajo estadoOrdenTrabajo;

    @PrePersist
    protected void onCreate(){
        fecha = LocalDateTime.now();
    }
}
