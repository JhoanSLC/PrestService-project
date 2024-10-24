package com.finalboss_project.finalboss.persona.domain.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalboss_project.finalboss.aprobacionServicio.domain.entity.AprobacionServicio;
import com.finalboss_project.finalboss.cuenta.domain.entity.Cuenta;
import com.finalboss_project.finalboss.emailPersona.domain.entity.EmailPersona;
import com.finalboss_project.finalboss.ordenServicio.domain.entity.OrdenServicio;
import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;
import com.finalboss_project.finalboss.personaInsumo.domain.entity.PersonaInsumo;
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
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persona",uniqueConstraints = {
    @UniqueConstraint(columnNames = {"usuario","nombre","apellido"})
})
public class Persona implements UserDetails {

    @Id
    @Column(length = 20)
    private String id;

    @Column(nullable = false)
    @NotEmpty(message = "El nombre de la persona no puede estar vacío")
    private String nombre;

    @Column(nullable = false)
    @NotEmpty(message = "El apellido de la persona no puede estar vacío")
    private String apellido;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String contraseña;

    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    private List<TelPersona> telPersona;

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    private List<EmailPersona> emailPersona;

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    private List<PersonaInsumo> personaInsumo;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<OrdenServicio> ordenServicios;

    @OneToMany(mappedBy = "empleado")
    @JsonIgnore
    private List<OrdenServicio> ordenServiciosEmpleado;

    @OneToMany(mappedBy = "empleado")
    @JsonIgnore
    private List<OrdenTrabajo> ordenTrabajos;

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    private List<AprobacionServicio> aprobacionServicios;

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    private List<Cuenta> cuentas;

    @ManyToOne
    @JoinColumn(name = "sucursalId",nullable = true)
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
            @NotEmpty(message = "El apellido de la persona no puede estar vacío") String apellido, String usuario,
            String contraseña, LocalDateTime fechaRegistro, Sucursal sucursal,
            @NotNull(message = "El id del tipo de persona no puede ser nulo") TipoPersona tipoPersona) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fechaRegistro = fechaRegistro;
        this.sucursal = sucursal;
        this.tipoPersona = tipoPersona;
    }

    public Persona(String id, @NotEmpty(message = "El nombre de la persona no puede estar vacío") String nombre,
            @NotEmpty(message = "El apellido de la persona no puede estar vacío") String apellido, String usuario,
            String contraseña, LocalDateTime fechaRegistro,
            @NotNull(message = "El id del tipo de persona no puede ser nulo") TipoPersona tipoPersona) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fechaRegistro = fechaRegistro;
        this.tipoPersona = tipoPersona;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public String getUsername() {
        return usuario;
    }
    

    
}
