package com.finalboss_project.finalboss.empresaServicio.domain.entity;


import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;
import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empresaServicio")
public class EmpresaServicio {

    @EmbeddedId
    EmpresaServicioPk id;

    @Column(nullable = false)
    @NotNull(message = "El valor del servicio no puede ser nulo")
    private Double valorServicio;

    @ManyToOne
    @MapsId("sucursalId")
    @JoinColumn(name = "sucursalId",nullable = false)
    @NotNull
    private Sucursal sucursal;

    @ManyToOne
    @MapsId("servicioId")
    @JoinColumn(name = "servicioId",nullable = false)
    @NotNull
    private Servicio servicio;
}
