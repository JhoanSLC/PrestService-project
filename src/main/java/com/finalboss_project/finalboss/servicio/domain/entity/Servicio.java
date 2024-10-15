package com.finalboss_project.finalboss.servicio.domain.entity;

import java.sql.Time;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.aprobacionServicio.domain.entity.AprobacionServicio;
import com.finalboss_project.finalboss.detalleOrdenServicio.domain.entity.DetalleOrdenServicio;
import com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.entity.DetalleOrdenTrabajo;
import com.finalboss_project.finalboss.empresaServicio.domain.entity.EmpresaServicio;
import com.finalboss_project.finalboss.personaInsumo.domain.entity.PersonaInsumo;
import com.finalboss_project.finalboss.servicioInsumo.domain.entity.ServicioInsumo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false,unique = true)
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;
    
    @Column(nullable = false)
    @NotNull(message = "El campo requiereInsumo no puede ser nulo")
    private Boolean requiereInsumo;

    private Time tiempoEjecucion;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private List<EmpresaServicio> empresaServicios;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private List<ServicioInsumo> servicioInsumos;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private List<DetalleOrdenServicio> detallesOrdenServicios;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private List<PersonaInsumo> personaInsumos;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private List<DetalleOrdenTrabajo> detallesOrdenTrabajo;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private List<AprobacionServicio> aprobacionServicios;


    public Servicio(Long id, @NotEmpty(message = "El nombre no puede estar vacío") String nombre,
            @NotNull(message = "ENDER PEARLLLLLLL") Boolean requiereInsumo, Time tiempoEjecucion) {
        this.id = id;
        this.nombre = nombre;
        this.requiereInsumo = requiereInsumo;
        this.tiempoEjecucion = tiempoEjecucion;
    }
}
