package com.finalboss_project.finalboss.aprobacionServicio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.aprobacionServicio.domain.entity.AprobacionServicio;

@Repository
public interface IAprobacionServicioRepository extends JpaRepository<AprobacionServicio, Long> {

}
