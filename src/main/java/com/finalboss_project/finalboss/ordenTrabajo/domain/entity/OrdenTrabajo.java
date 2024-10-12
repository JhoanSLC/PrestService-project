package com.finalboss_project.finalboss.ordenTrabajo.domain.entity;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.aprobacionServicio.domain.entity.AprobacionServicio;
import com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.entity.DetalleOrdenTrabajo;
import com.finalboss_project.finalboss.ordenServicio.domain.entity.OrdenServicio;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name = "ordenTrabajo")
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String numeroOrdenTrabajo;

    @Column
    private Date fechaAsignacion;

    @Column
    private Time horaAsignacion;  

    @ManyToOne
    @JoinColumn(name = "empleadoId",nullable = false)
    @NotNull
    private Persona empleado;

    @ManyToOne
    @JoinColumn(name = "ordenServicioId",nullable = false)
    @NotNull
    private OrdenServicio ordenServicio;

    @OneToMany(mappedBy = "ordenTrabajo",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetalleOrdenTrabajo> detallesOrdenTrabajo;

    @OneToMany(mappedBy = "ordenTrabajo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AprobacionServicio> aprobacionServicios;

    @PrePersist
    protected void onCreate(){
        fechaAsignacion = Date.valueOf(LocalDate.now());
        horaAsignacion = Time.valueOf(LocalTime.now());
    }

    public OrdenTrabajo(Long id, String numeroOrdenTrabajo, Date fechaAsignacion, Time horaAsignacion,
            @NotNull Persona empleado, @NotNull OrdenServicio ordenServicio) {
        this.id = id;
        this.numeroOrdenTrabajo = numeroOrdenTrabajo;
        this.fechaAsignacion = fechaAsignacion;
        this.horaAsignacion = horaAsignacion;
        this.empleado = empleado;
        this.ordenServicio = ordenServicio;
    }

    

}
