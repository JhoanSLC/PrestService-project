package com.finalboss_project.finalboss.empresa.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.empresa.domain.entity.Empresa;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, Long>{

}
