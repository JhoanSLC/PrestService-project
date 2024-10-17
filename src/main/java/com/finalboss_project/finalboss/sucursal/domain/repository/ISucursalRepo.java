package com.finalboss_project.finalboss.sucursal.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;

@Repository
public interface ISucursalRepo extends JpaRepository<Sucursal,Long> {

}
