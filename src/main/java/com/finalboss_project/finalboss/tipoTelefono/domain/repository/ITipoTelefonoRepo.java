package com.finalboss_project.finalboss.tipoTelefono.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.tipoTelefono.domain.entity.TipoTelefono;

@Repository
public interface ITipoTelefonoRepo extends JpaRepository<TipoTelefono,Long> {

}
