package com.finalboss_project.finalboss.servicioInsumo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.servicioInsumo.domain.entity.ServicioInsumo;
import com.finalboss_project.finalboss.servicioInsumo.domain.entity.ServicioInsumoPk;

@Repository
public interface IServicioInsumoRepo extends JpaRepository<ServicioInsumo,ServicioInsumoPk> {

}
