package com.finalboss_project.finalboss.ciudad.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.ciudad.domain.entity.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad,Long> {

}
