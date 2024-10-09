package com.finalboss_project.finalboss.empresa.domain.entity;

import com.finalboss_project.finalboss.tipoEmpresa.domain.entity.TipoEmpresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "tipoEmpresaId")
    private TipoEmpresa tipoEmpresa;
}
