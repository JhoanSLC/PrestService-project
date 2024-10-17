package com.finalboss_project.finalboss.persona.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.persona.domain.entity.Persona;

@Repository 
public interface IPersonaRepo extends JpaRepository<Persona,String> {

}
