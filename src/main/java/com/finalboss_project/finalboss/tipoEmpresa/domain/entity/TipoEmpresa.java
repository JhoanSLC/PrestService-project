package com.finalboss_project.finalboss.tipoEmpresa.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.empresa.domain.entity.Empresa;

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

/**
 * Representa la entidad TipoEmpresa en la base de datos.
 * 
 * Contiene los atributos id y descripcion, donde id es la clave 
 * primaria autogenerada y descripcion es un campo obligatorio.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipoEmpresa")
public class TipoEmpresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "La descripción del tipo de empresa no puede estar vacía")
    private String descripcion;

    @OneToMany(mappedBy = "tipoEmpresa")
    @JsonIgnore
    private List<Empresa> empresas;

    public TipoEmpresa(Long id,
            @NotEmpty(message = "La descripción del tipo de empresa no puede estar vacía") String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
}
