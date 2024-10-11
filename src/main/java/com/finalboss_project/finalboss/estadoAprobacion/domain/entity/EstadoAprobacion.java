package com.finalboss_project.finalboss.estadoAprobacion.domain.entity;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.aprobacionServicio.domain.entity.AprobacionServicio;

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

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name = "estadoAprobacion")
public class EstadoAprobacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60,nullable = false,unique = true)
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "estadoAprobacion",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AprobacionServicio> aprobacionServicios;

    public EstadoAprobacion(Long id, @NotEmpty String name) {
        this.id = id;
        this.name = name;
    }
}