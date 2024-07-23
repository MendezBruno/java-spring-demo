package com.bruno.galaxy.planets.domain.ports.in;

import com.bruno.galaxy.planets.domain.model.Planet;

import java.util.List;
import java.util.Optional;

public interface RetrievePlanetUseCase {
    Optional<Planet> getPlanetById(Long id);
    List<Planet> getAllPlanets();
}
