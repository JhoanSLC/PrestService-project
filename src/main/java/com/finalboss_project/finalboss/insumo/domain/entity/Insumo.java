package com.finalboss_project.finalboss.insumo.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.personaInsumo.domain.entity.PersonaInsumo;
import com.finalboss_project.finalboss.servicioInsumo.domain.entity.ServicioInsumo;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "insumo")
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    @NotEmpty(message = "El codigo interno del insumo no puede estar vacío")
    private String codigoInterno;   

    @Column(length = 40,nullable = false)
    @NotEmpty(message = "El nombre del insumo no puede estar vacío")
    private String nombre;

    @Column(nullable = false)
    @NotNull(message = "El precio unitario del insumo no puede ser nulo")
    private Double precioUnitario;

    @OneToMany(mappedBy = "insumo")
    @JsonIgnore
    private List<ServicioInsumo> servicioInsumos;

    @OneToMany(mappedBy = "insumo")
    @JsonIgnore
    private List<PersonaInsumo> personaInsumos;

    public Insumo(Long id,
            @NotEmpty(message = "El codigo interno del insumo no puede estar vacío") String codigoInterno,
            @NotEmpty(message = "El nombre del insumo no puede estar vacío") String nombre,
            @NotNull(message = "El precio unitario del insumo no puede ser nulo") Double precioUnitario) {
        this.id = id;
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    
}
