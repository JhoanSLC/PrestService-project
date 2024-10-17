package com.finalboss_project.finalboss.personaInsumo.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PersonaInsumoPk implements Serializable {

    private String personaId;
    private Long insumoId;
}
