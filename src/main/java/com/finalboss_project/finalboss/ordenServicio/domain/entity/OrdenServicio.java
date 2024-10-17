package com.finalboss_project.finalboss.ordenServicio.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.estadoOrdenServicio.domain.entity.EstadoOrdenServicio;
import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordenServicio")
public class OrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date fechaOrden;

    @ManyToOne
    @JoinColumn(name = "clienteId",nullable = false)
    @NotNull
    private Persona cliente;

    @ManyToOne
    @JoinColumn(name = "empleadoId",nullable = false)
    @NotNull
    private Persona empleado;

    @ManyToOne
    @JoinColumn(name = "estadoOrdenServicioId",nullable = false)
    @NotNull
    private EstadoOrdenServicio estadoOrdenServicio;

    @OneToMany(mappedBy = "ordenServicio")
    @JsonIgnore
    private List<OrdenTrabajo> ordenTrabajo;

    public OrdenServicio(Long id, Date fechaOrden, @NotNull Persona cliente, @NotNull Persona empleado,
            @NotNull EstadoOrdenServicio estadoOrdenServicio) {
        this.id = id;
        this.fechaOrden = fechaOrden;
        this.cliente = cliente;
        this.empleado = empleado;
        this.estadoOrdenServicio = estadoOrdenServicio;
    }
}
