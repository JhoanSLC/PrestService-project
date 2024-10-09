package com.finalboss_project.finalboss.pais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.pais.domain.entity.Pais;

@Repository
public interface IPaisRepository extends JpaRepository<Pais,Long> {

}
