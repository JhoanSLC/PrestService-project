package com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.entity.EstadoOrdenTrabajo;

@Repository
public interface IEstadoOrdenTrabajoRepo extends JpaRepository<EstadoOrdenTrabajo,Long> {

}
