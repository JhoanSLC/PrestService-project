package com.finalboss_project.finalboss.ciudad.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.direccion.domain.entity.Direccion;
import com.finalboss_project.finalboss.region.domain.entity.Region;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ciudad",uniqueConstraints = @UniqueConstraint(columnNames = {"nombre","regionId"}))
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "El nombre de la ciudad no puede estar vacío")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "regionId", nullable = false)
    @NotNull(message = "El id de la región no puede ser nulo")
    private Region region;

    @OneToMany(mappedBy = "ciudad")
    @JsonIgnore
    private List<Direccion> direcciones;
}
