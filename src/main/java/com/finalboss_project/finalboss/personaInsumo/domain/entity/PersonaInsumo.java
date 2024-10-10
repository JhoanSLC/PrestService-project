package com.finalboss_project.finalboss.personaInsumo.domain.entity;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    

}
