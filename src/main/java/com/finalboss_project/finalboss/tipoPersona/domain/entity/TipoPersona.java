package com.finalboss_project.finalboss.tipoPersona.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.finalboss_project.finalboss.persona.domain.entity.Persona;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipoPersona")
public class TipoPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String nombre;

    @OneToMany(mappedBy = "tipoPersona")
    private List<Persona> personas;

}
