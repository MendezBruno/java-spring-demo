package com.bruno.galaxy.planets.domain.ports.in;

import com.bruno.galaxy.planets.domain.model.Planet;

public interface CreatePlanetUseCase {
    Planet createPlanet(Planet planet);
}
