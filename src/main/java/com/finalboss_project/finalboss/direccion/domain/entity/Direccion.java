package com.finalboss_project.finalboss.direccion.domain.entity;

import com.finalboss_project.finalboss.ciudad.domain.entity.Ciudad;
import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;

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
    @NotEmpty(message = "La calle de la dirección no puede estar vacía")
    private String calle;

    @Column(nullable = false)
    @NotEmpty(message = "La carrera de la dirección no puede estar vacía")
    private String carrera;

    @Column(nullable = true)
    private String descripcion;

    @Column(nullable = false)
    @NotEmpty(message = "El barrio de la dirección no puede estar vacía")
    private String barrio;

    @ManyToOne
    @JoinColumn(name = "ciudadId", nullable = false)
    @NotNull(message = "El id de la ciudad para la dirección no puede ser nula")
    private Ciudad ciudad;

    @OneToOne(mappedBy = "direccion")
    @JoinColumn(name = "sucursalId",nullable = false)
    private Sucursal sucursal;

    public Direccion(Long id, @NotEmpty(message = "La calle de la dirección no puede estar vacía") String calle,
            @NotEmpty(message = "La carrera de la dirección no puede estar vacía") String carrera, String descripcion,
            @NotEmpty(message = "El barrio de la dirección no puede estar vacía") String barrio,
            @NotNull(message = "El id de la ciudad para la dirección no puede ser nula") Ciudad ciudad) {
        this.id = id;
        this.calle = calle;
        this.carrera = carrera;
        this.descripcion = descripcion;
        this.barrio = barrio;
        this.ciudad = ciudad;
    }

    

}
