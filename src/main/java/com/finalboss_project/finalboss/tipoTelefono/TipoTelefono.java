package com.finalboss_project.finalboss.tipoTelefono;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.telPersona.domain.entity.TelPersona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name = "tipoTelefono")
public class TipoTelefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotEmpty(message = "El nombre del tipo de telefono no puede estar vacío")
    private String nombre;

    @OneToMany(mappedBy = "tipoTelefono")
    @JsonIgnore
    private List<TelPersona> telPersona;

    public TipoTelefono(Long id, @NotEmpty String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
