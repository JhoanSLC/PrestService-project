package com.finalboss_project.finalboss.telPersona.domain.entity;


import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.tipoTelefono.TipoTelefono;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "telPersona")
public class TelPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "El número de telefono no puede ser nulo")
    private Long numero;

    @ManyToOne
    @JoinColumn(name = "tipoTelefonoId",nullable = false)
    @NotNull(message = "El ID del tipo de telefono no puede ser nulo")
    private TipoTelefono tipoTelefono;

    @ManyToOne
    @JoinColumn(name = "personaId",nullable = false)
    @NotNull(message = "El ID de la persona no puede ser nulo")
    private Persona persona;

}
