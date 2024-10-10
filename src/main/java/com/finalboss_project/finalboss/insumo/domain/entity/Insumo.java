package com.finalboss_project.finalboss.insumo.domain.entity;

import java.util.List;

import org.springframework.validation.annotation.Validated;

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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
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

    private Integer stock;
    private Integer stockMinimo;
    private Integer stockMaximo;

    @OneToMany(mappedBy = "insumo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<ServicioInsumo> servicioInsumos;

    @OneToMany(mappedBy = "insumo",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<PersonaInsumo> personaInsumos;

    public Insumo(Long id,
            @NotEmpty(message = "El codigo interno del insumo no puede estar vacío") String codigoInterno,
            @NotEmpty(message = "El nombre del insumo no puede estar vacío") String nombre,
            @NotNull(message = "El precio unitario del insumo no puede ser nulo") Double precioUnitario, Integer stock,
            Integer stockMinimo, Integer stockMaximo) {
        this.id = id;
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
    }

    
}
