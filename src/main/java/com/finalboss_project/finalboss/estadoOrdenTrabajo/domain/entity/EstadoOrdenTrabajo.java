package com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.entity.DetalleOrdenTrabajo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
@Table(name = "estadoOrdenTrabajo")
public class EstadoOrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50,nullable = false,unique = true)
    @NotEmpty
    private String nombre;

    @OneToMany(mappedBy = "estadoOrdenTrabajo")
    @JsonIgnore
    private List<DetalleOrdenTrabajo> detalleOrdenTrabajos;

    public EstadoOrdenTrabajo(Long id, @NotEmpty String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
}
