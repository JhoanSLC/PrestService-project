package com.finalboss_project.finalboss.cuenta.domain.entity;

import org.springframework.validation.annotation.Validated;

import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.rol.domain.entity.Rol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Validated
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(unique = true,nullable = false)
    private String usuario;

    @NotEmpty
    @Column(unique = true,nullable = false)
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "rolId")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "personaId")
    private Persona persona;

}
