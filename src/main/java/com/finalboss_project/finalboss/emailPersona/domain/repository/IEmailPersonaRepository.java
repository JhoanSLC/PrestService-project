package com.finalboss_project.finalboss.emailPersona.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.emailPersona.domain.entity.EmailPersona;

@Repository
public interface IEmailPersonaRepository extends JpaRepository<EmailPersona,Long>{

}
