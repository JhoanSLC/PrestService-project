package com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.entity.DetalleOrdenTrabajo;

@Repository
public interface IDetalleOrdenTrabajoRepo extends JpaRepository<DetalleOrdenTrabajo,Long>{

}
