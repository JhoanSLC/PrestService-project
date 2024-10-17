package com.finalboss_project.finalboss.insumo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.insumo.domain.entity.Insumo;

@Repository
public interface IInsumoRepo extends JpaRepository<Insumo,Long> {

}
