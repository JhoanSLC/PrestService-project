package com.finalboss_project.finalboss.ordenTrabajo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;

@Repository
public interface IOrdenTrabajoRepository extends JpaRepository<OrdenTrabajo,Long> {

}
