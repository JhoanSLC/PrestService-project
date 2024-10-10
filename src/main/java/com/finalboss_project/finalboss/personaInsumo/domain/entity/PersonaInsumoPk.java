package com.finalboss_project.finalboss.personaInsumo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PersonaInsumoPk {

    @Column(name = "personaId")
    private Long personaId;

    @Column(name = "insumoId")
    private Long insumoId;
}
