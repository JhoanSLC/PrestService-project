package com.finalboss_project.finalboss.region.domain.entity;

import java.util.List;

import com.finalboss_project.finalboss.ciudad.domain.entity.Ciudad;
import com.finalboss_project.finalboss.pais.domain.entity.Pais;

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
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    @NotEmpty(message = "El nombre de la región no puede estar vacío")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "paisId",nullable = false)
    @NotNull(message = "El ID del país no puede ser nulo")
    private Pais pais;

    @OneToMany(mappedBy = "region")
    private List<Ciudad> ciudades;

    public Region(Long id, @NotEmpty(message = "El nombre de la región no puede estar vacío") String nombre,
            @NotNull(message = "El ID del país no puede ser nulo") Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }
}
