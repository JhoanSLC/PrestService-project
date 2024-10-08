package com.finalboss_project.finalboss.tipoEmpresa.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "tipoEmpresaId")
    private Long id;

    @Column(nullable = false)
    private String descripcion;
}
