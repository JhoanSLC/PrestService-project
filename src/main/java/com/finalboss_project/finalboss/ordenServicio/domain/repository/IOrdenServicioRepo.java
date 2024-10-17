package com.finalboss_project.finalboss.ordenServicio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.finalboss_project.finalboss.ordenServicio.domain.entity.OrdenServicio;

@Repository
public interface IOrdenServicioRepo extends JpaRepository<OrdenServicio,Long> {

}
