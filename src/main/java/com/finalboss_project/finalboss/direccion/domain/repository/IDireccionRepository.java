package com.finalboss_project.finalboss.direccion.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.direccion.domain.entity.Direccion;

@Repository
public interface IDireccionRepository extends JpaRepository<Direccion,Long> {

}
