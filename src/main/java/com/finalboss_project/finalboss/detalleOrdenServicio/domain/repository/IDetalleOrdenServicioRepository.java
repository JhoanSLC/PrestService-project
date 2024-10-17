package com.finalboss_project.finalboss.detalleOrdenServicio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.detalleOrdenServicio.domain.entity.DetalleOrdenServicio;


@Repository
public interface IDetalleOrdenServicioRepository extends JpaRepository<DetalleOrdenServicio,Long>{

}
