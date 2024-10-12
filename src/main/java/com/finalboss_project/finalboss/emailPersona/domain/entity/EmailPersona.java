package com.finalboss_project.finalboss.emailPersona.domain.entity;

import org.springframework.validation.annotation.Validated;

import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.tipoEmail.domain.entity.TipoEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name = "emailPersona")
public class EmailPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150,nullable = false)
    @NotEmpty(message = "El email no puede estar vacío")
    private String email;

    @ManyToOne
    @JoinColumn(name = "personaId",nullable = false)
    @NotNull(message = "El id de la persona a la que pertenece este email no puede ser nulo")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "tipoEmailId")
    private TipoEmail tipoEmail;

}
