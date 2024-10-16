package com.finalboss_project.finalboss.rol.domain.entity;

import java.util.List;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.cuenta.domain.entity.Cuenta;

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
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    @NotEmpty
    private String nombre;

    @OneToMany(mappedBy = "rol")
    @JsonIgnore
    private List<Cuenta> cuenta;

    public Rol(Long id, @NotEmpty String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
