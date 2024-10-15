package com.finalboss_project.finalboss.empresaServicio.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaServicioPk implements Serializable {

    private Long sucursalId;
    private Long servicioId;

}
