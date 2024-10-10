package com.finalboss_project.finalboss.servicioInsumo.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ServicioInsumoPk implements Serializable{

    @Column(name = "insumoId")
    private Long insumoId;

    @Column(name = "servicioId")
    private Long servicioId;

}
