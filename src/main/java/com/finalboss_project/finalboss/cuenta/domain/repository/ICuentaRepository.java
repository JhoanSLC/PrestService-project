package com.finalboss_project.finalboss.cuenta.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.cuenta.domain.entity.Cuenta;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta,Long>{

}
