package com.finalboss_project.finalboss.servicioInsumo.domain.entity;

import org.springframework.validation.annotation.Validated;

import com.finalboss_project.finalboss.insumo.domain.entity.Insumo;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;

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
@Validated
@Entity
@Table(name = "servicioInsumo")
public class ServicioInsumo {

    @EmbeddedId
    private ServicioInsumoPk id;

    @Column(nullable = false)
    @NotNull(message = "El valor unitario no puede ser nulo")
    private Double valorUnitario;

    private Integer stock;
    private Integer stockMin;
    private Integer stockMax;

    @ManyToOne
    @MapsId("servicioId")
    @JoinColumn(name = "servicioId",referencedColumnName = "id",insertable = false,updatable = false,nullable = false)
    @NotNull(message = "El ID del servicio no puede ser nulo")
    private Servicio servicio;

    @ManyToOne
    @MapsId("insumoId")
    @JoinColumn(name = "insumoId",referencedColumnName = "id",insertable = false,updatable = false,nullable = false)
    @NotNull(message = "El ID del servicio no puede ser nulo")
    private Insumo insumo;
}
