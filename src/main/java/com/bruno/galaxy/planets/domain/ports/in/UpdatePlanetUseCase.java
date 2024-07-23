package com.bruno.galaxy.planets.domain.ports.in;

import com.bruno.galaxy.planets.domain.model.Planet;

import java.util.Optional;

public interface UpdatePlanetUseCase {
    Optional<Planet> updatePlanet(Long id, Planet updatedPlanet);
}
