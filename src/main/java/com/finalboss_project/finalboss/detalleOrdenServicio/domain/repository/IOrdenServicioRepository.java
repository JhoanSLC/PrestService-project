package com.finalboss_project.finalboss.detalleOrdenServicio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.ordenServicio.domain.entity.OrdenServicio;

@Repository
public interface IOrdenServicioRepository extends JpaRepository<OrdenServicio,Long>{

}
