package com.finalboss_project.finalboss.tipoPersona.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;

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
@Table(name = "tipoPersona")
public class TipoPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String nombre;

    @OneToMany(mappedBy = "tipoPersona")
    @JsonIgnore
    private List<Persona> personas;

    public TipoPersona(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
}
