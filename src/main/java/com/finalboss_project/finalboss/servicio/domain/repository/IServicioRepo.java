package com.finalboss_project.finalboss.servicio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;

@Repository
public interface IServicioRepo extends JpaRepository<Servicio,Long>{

}
