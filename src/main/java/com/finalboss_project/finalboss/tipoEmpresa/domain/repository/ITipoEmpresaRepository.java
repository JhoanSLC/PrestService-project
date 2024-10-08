package com.finalboss_project.finalboss.tipoEmpresa.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.tipoEmpresa.domain.entity.TipoEmpresa;

/**
 * Repositorio para la entidad TipoEmpresa.
 * 
 * Extiende JpaRepository para proporcionar métodos CRUD 
 * para la tabla correspondiente en la base de datos.
 */
@Repository
public interface ITipoEmpresaRepository extends JpaRepository<TipoEmpresa,Long> {

}
