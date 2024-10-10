package com.finalboss_project.finalboss.direccion.domain.entity;

import com.finalboss_project.finalboss.ciudad.domain.entity.Ciudad;
import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String calle;

    @Column(nullable = false)
    @NotEmpty
    private String carrera;

    @Column(nullable = true)
    @NotEmpty
    private String descripcion;

    @Column(nullable = false)
    @NotEmpty
    private String barrio;

    @ManyToOne
    @JoinColumn(name = "ciudadId", nullable = false)
    @NotNull
    private Ciudad ciudad;

    @OneToOne(mappedBy = "direccion")
    private Sucursal sucursal;

    

}
