package com.finalboss_project.finalboss.estadoAprobacion.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.estadoAprobacion.domain.entity.EstadoAprobacion;

@Repository
public interface IEstadoAprobacionRepo extends JpaRepository<EstadoAprobacion,Long> {

}
