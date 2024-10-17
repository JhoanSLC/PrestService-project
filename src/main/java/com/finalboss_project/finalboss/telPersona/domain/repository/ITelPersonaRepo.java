package com.finalboss_project.finalboss.telPersona.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.telPersona.domain.entity.TelPersona;

@Repository
public interface ITelPersonaRepo extends JpaRepository<TelPersona,Long> {

}
