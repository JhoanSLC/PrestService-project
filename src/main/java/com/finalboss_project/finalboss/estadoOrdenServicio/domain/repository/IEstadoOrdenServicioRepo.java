package com.finalboss_project.finalboss.estadoOrdenServicio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.estadoOrdenServicio.domain.entity.EstadoOrdenServicio;

@Repository
public interface IEstadoOrdenServicioRepo extends JpaRepository<EstadoOrdenServicio,Long> {

}
