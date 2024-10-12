package com.finalboss_project.finalboss.region.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalboss_project.finalboss.region.domain.entity.Region;

@Repository
public interface IRegionRepository extends JpaRepository<Region,Long> {

}
