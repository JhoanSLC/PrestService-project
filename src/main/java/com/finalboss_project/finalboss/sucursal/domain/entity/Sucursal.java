package com.finalboss_project.finalboss.sucursal.domain.entity;

import java.sql.Timestamp;

import com.finalboss_project.finalboss.direccion.domain.entity.Direccion;
import com.finalboss_project.finalboss.empresa.domain.entity.Empresa;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.finalboss_project.finalboss.persona.domain.entity.Persona;

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
    @NotEmpty
    private String nombre;

    @Column(nullable = false)
    @NotEmpty
    private String nit;

    private Timestamp fechaCreacion;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "direccionId", nullable = false)
    @NotNull
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "empresaId", nullable = false)
    @NotNull
    private Empresa empresa;

    @OneToMany(mappedBy = "sucursal")
    private List<Persona> personas;
}
