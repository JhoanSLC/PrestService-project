package com.finalboss_project.finalboss.tipoPersona.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.tipoPersona.domain.entity.TipoPersona;

@Repository
public interface ITipoPersonaRepository extends JpaRepository<TipoPersona,Long> {

    
}
