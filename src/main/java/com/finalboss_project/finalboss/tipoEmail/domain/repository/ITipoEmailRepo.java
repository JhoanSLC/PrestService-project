package com.finalboss_project.finalboss.tipoEmail.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.tipoEmail.domain.entity.TipoEmail;

@Repository
public interface ITipoEmailRepo extends JpaRepository<TipoEmail,Long> {

}
