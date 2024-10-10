package com.finalboss_project.finalboss.pais.domain.entity;

import java.util.List;

import com.finalboss_project.finalboss.region.domain.entity.Region;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    @NotEmpty(message = "El nombre del país no puede estar vacío")
    private String nombre;

    @OneToMany(mappedBy = "pais",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Region> regiones;

    public Pais(Long id, @NotEmpty(message = "El nombre del país no puede estar vacío") String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}

   