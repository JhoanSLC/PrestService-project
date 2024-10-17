package com.finalboss_project.finalboss.detalleOrdenServicio.domain.entity;


import com.finalboss_project.finalboss.ordenServicio.domain.entity.OrdenServicio;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;

import jakarta.persistence.Column;
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
@Entity
@Table(name = "detalleOrdenServicio")
public class DetalleOrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private Double valorServicio;

    @ManyToOne
    @JoinColumn(name = "ordenServicioId",nullable = false)
    @NotNull
    private OrdenServicio ordenServicio;

    @ManyToOne
    @JoinColumn(name = "servicioId",nullable = false)
    @NotNull
    private Servicio servicio;
}
