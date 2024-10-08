package com.finalboss_project.finalboss.tipoEmpresa.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.tipoEmpresa.domain.entity.TipoEmpresa;

@Repository
public interface ITipoEmpresaRepository extends JpaRepository<TipoEmpresa,Long> {

}
