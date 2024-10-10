package com.finalboss_project.finalboss.empresa.domain.entity;

import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;
import com.finalboss_project.finalboss.tipoEmpresa.domain.entity.TipoEmpresa;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "tipoEmpresaId",nullable = false)
    @NotNull
    private TipoEmpresa tipoEmpresa;

    @OneToMany(mappedBy = "empresa")
    private List<Sucursal> sucursales;

    public Empresa(Long id, String nombre, TipoEmpresa tipoEmpresa) {
        this.id = id;
        this.nombre = nombre;
        this.tipoEmpresa = tipoEmpresa;
    }

    
}