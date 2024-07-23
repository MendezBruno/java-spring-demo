package com.bruno.galaxy.planets.infrastructure.repositories;

import com.bruno.galaxy.planets.infrastructure.entities.PlanetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPlanetRepository extends JpaRepository<PlanetEntity, Long> {
}
