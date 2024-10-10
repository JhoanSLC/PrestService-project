package com.finalboss_project.finalboss.persona.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;
import com.finalboss_project.finalboss.tipoPersona.domain.entity.TipoPersona;

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
    private String nombre;

    @Column(nullable = false)
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
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "tipoPersonaId", nullable = false)
    private TipoPersona tipoPersona;

    @PrePersist
    protected void onCreate(){
        fechaRegistro = LocalDateTime.now();
    }
}
