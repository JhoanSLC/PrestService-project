package com.finalboss_project.finalboss.servicioInsumo.domain.entity;

import java.io.Serializable;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Embeddable
public class ServicioInsumoPk implements Serializable{

    @Column(name = "insumoId")
    @NotNull
    private Long insumoId;

    @Column(name = "servicioId")
    @NotNull
    private Long servicioId;

}
