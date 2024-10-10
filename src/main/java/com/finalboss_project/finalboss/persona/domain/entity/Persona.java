package com.finalboss_project.finalboss.persona.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.finalboss_project.finalboss.emailPersona.domain.entity.EmailPersona;
import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;
import com.finalboss_project.finalboss.telPersona.domain.entity.TelPersona;
import com.finalboss_project.finalboss.tipoPersona.domain.entity.TipoPersona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(length = 20)
    private String id;

    @Column(nullable = false)
    @NotEmpty(message = "El nombre de la persona no puede estar vacío")
    private String nombre;

    @Column(nullable = false)
    @NotEmpty(message = "El apellido de la persona no puede estar vacío")
    private String apellido;

    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "persona")
    private List<TelPersona> telPersona;

    @OneToMany(mappedBy = "persona")
    private List<EmailPersona> emailPersona;

    @OneToMany(mappedBy = "persona")
    private List<PersonaInsumo> personaInsumo;

    @ManyToOne
    @JoinColumn(name = "sucursalId",nullable = false)
    @NotNull(message = "El id de la sucursal no puede ser nula")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "tipoPersonaId", nullable = false)
    @NotNull(message = "El id del tipo de persona no puede ser nulo")
    private TipoPersona tipoPersona;

    @PrePersist
    protected void onCreate(){
        fechaRegistro = LocalDateTime.now();
    }

    public Persona(String id, @NotEmpty(message = "El nombre de la persona no puede estar vacío") String nombre,
            @NotEmpty(message = "El apellido de la persona no puede estar vacío") String apellido,
            LocalDateTime fechaRegistro, @NotNull(message = "El id de la sucursal no puede ser nula") Sucursal sucursal,
            @NotNull(message = "El id del tipo de persona no puede ser nulo") TipoPersona tipoPersona) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaRegistro = fechaRegistro;
        this.sucursal = sucursal;
        this.tipoPersona = tipoPersona;
    }

    
}
