package com.finalboss_project.finalboss.tipoEmail.domain.entity;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.emailPersona.domain.entity.EmailPersona;

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
@Entity
@Table(name = "tipoEmail")
public class TipoEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    @NotEmpty(message = "El nombre del tipoEmail no puede estar vacío")
    private String nombre;

    @OneToMany(mappedBy = "tipoEmail")
    @JsonIgnore
    private List<EmailPersona> emailPersona;

    public TipoEmail(Long id, @NotEmpty(message = "El nombre del tipoEmail no puede estar vacío") String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
