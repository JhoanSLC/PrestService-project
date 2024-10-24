package com.finalboss_project.finalboss.utils;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.finalboss_project.finalboss.persona.domain.entity.Persona;

public class PersonaDetails implements UserDetails {
    private final Persona persona;

    public PersonaDetails(Persona persona) {
        this.persona = persona;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aquí puedes mapear los roles desde la entidad Persona o TipoPersona
        return List.of(() -> "ROLE_USER"); // Ejemplo, debes adaptarlo
    }

    @Override
    public String getPassword() {
        return persona.getContraseña();
    }

    @Override
    public String getUsername() {
        return persona.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Lógica adicional según tu caso
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Lógica adicional según tu caso
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Lógica adicional según tu caso
    }

    @Override
    public boolean isEnabled() {
        return true; // Lógica adicional según tu caso
    }

    public Persona getPersona() {
        return persona;
    }
}
