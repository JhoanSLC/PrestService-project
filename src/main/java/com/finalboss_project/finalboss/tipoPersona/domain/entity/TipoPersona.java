package com.finalboss_project.finalboss.tipoPersona.domain.entity;

<<<<<<< HEAD
import org.hibernate.mapping.List;
=======
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
>>>>>>> a4ab640d92cb361927e60c7ed32590240dad0d3a

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
<<<<<<< HEAD
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
=======
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
>>>>>>> a4ab640d92cb361927e60c7ed32590240dad0d3a
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
<<<<<<< HEAD
<<<<<<< HEAD
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
    
=======
=======
    @Column(name = "id")
>>>>>>> bef3bec3a060e28cba40e47a3fe87d6276a5582a
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
<<<<<<< HEAD
>>>>>>> a4ab640d92cb361927e60c7ed32590240dad0d3a
=======
    
>>>>>>> bef3bec3a060e28cba40e47a3fe87d6276a5582a
}
