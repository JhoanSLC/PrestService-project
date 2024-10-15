package com.finalboss_project.finalboss.personaInsumo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.personaInsumo.domain.entity.PersonaInsumo;
import com.finalboss_project.finalboss.personaInsumo.domain.entity.PersonaInsumoPk;

@Repository
public interface IPersonaInsumoRepo extends JpaRepository<PersonaInsumo,PersonaInsumoPk> {

}
