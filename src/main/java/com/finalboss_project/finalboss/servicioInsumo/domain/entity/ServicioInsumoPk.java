package com.finalboss_project.finalboss.servicioInsumo.domain.entity;

import java.io.Serializable;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ServicioInsumoPk implements Serializable{

    private Long insumoId;
    private Long servicioId;

}
