package com.bruno.galaxy.planets.domain.ports.out;

import com.bruno.galaxy.planets.domain.model.Planet;

import java.util.List;
import java.util.Optional;

public interface PlanetRepositoryPort {
    Planet save(Planet planet);
    Optional<Planet> findById(Long id);
    List<Planet> findAll();
    Optional<Planet> update(Planet planet);
    boolean deleteById(Long id);
}
