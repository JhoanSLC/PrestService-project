package com.finalboss_project.finalboss.personaInsumo.domain.entity;

import org.springframework.validation.annotation.Validated;

import com.finalboss_project.finalboss.insumo.domain.entity.Insumo;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name = "personaInsumo")
public class PersonaInsumo {

    @EmbeddedId
    private PersonaInsumo id;

    @ManyToOne
    @JoinColumn(name = "servicioId",nullable = false)
    @NotNull(message = "El ID del servicio no puede ser nulo")
    private Servicio servicio;

    @ManyToOne
    @MapsId("personaId")
    @JoinColumn(name = "personaId",insertable = false,updatable = false,nullable = false,referencedColumnName = "id")
    @NotNull(message = "El ID de la persona no puede ser nulo")
    private Persona persona;

    @ManyToOne
    @MapsId("insumoId")
    @JoinColumn(name = "insumoId",insertable = false,updatable = false,nullable = false,referencedColumnName = "id")
    @NotNull(message = "El ID del insumo no puede ser nulo")
    private Insumo insumo;
    

}
