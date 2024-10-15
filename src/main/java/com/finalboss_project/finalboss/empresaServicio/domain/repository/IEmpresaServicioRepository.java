package com.finalboss_project.finalboss.empresaServicio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.empresaServicio.domain.entity.EmpresaServicio;
import com.finalboss_project.finalboss.empresaServicio.domain.entity.EmpresaServicioPk;

@Repository
public interface IEmpresaServicioRepository extends JpaRepository<EmpresaServicio,EmpresaServicioPk> {

}
