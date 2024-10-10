package com.finalboss_project.finalboss.tipoEmail.domain.entity;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.finalboss_project.finalboss.emailPersona.domain.entity.EmailPersona;

import jakarta.persistence.CascadeType;
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
@Validated
@Table(name = "tipoEmail")
public class TipoEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    @NotEmpty
    private String nombre;

    @OneToMany(mappedBy = "tipoEmail",cascade = CascadeType.PERSIST)
    private List<EmailPersona> emailPersona;

    public TipoEmail(Long id, @NotEmpty String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
}
