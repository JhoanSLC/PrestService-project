package com.finalboss_project.finalboss.sucursal.domain.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.direccion.domain.entity.Direccion;
import com.finalboss_project.finalboss.empresa.domain.entity.Empresa;
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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "El nombre de la surcursal no puede estar vacío")
    private String nombre;

    @Column(nullable = false)
    @NotEmpty(message = "El NIT de la empresa no puede estar vacío")
    private String nit;

    private Date fechaCreacion = Date.valueOf(LocalDate.now());

    @ManyToOne
    @JoinColumn(name = "direccionId", nullable = false)
    @NotNull(message = "El ID de la dirección no puede ser nulo")
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "empresaId", nullable = false)
    @NotNull(message = "El ID de la empresa no puede ser nulo")
    private Empresa empresa;

    @OneToMany(mappedBy = "sucursal")
    @JsonIgnore
    private List<Persona> personas;

    public Sucursal(Long id, @NotEmpty(message = "El nombre de la surcursal no puede estar vacío") String nombre,
            @NotEmpty(message = "El NIT de la empresa no puede estar vacío") String nit, Date fechaCreacion,
            @NotNull(message = "El ID de la dirección no puede ser nulo") Direccion direccion,
            @NotNull(message = "El ID de la empresa no puede ser nulo") Empresa empresa) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.fechaCreacion = fechaCreacion;
        this.direccion = direccion;
        this.empresa = empresa;
    }

 
   
}
