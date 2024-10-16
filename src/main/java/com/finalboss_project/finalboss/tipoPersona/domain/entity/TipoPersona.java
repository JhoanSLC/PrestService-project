package com.finalboss_project.finalboss.tipoPersona.domain.entity;

import org.hibernate.mapping.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private String nombre;

    @OneToMany(mappedBy = "tipoPersona", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Persona> personas;

    public TipoPersona(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
}
