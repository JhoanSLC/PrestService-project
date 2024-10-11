package com.finalboss_project.finalboss.estadoOrdenServicio.domain.entity;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.ordenServicio.domain.entity.OrdenServicio;

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

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name = "estadoOrdenServicio")
public class EstadoOrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50,nullable = false,unique = true)
    @NotEmpty
    private String nombre;

    @OneToMany(mappedBy = "estadoOrdenServicio")
    @JsonIgnore
    private List<OrdenServicio> ordenServicios;

    public EstadoOrdenServicio(Long id, @NotNull String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
