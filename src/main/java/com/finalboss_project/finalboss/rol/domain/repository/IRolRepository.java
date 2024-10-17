package com.finalboss_project.finalboss.rol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.rol.domain.entity.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Long> {

}
