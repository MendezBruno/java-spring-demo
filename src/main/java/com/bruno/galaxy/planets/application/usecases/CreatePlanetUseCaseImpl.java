package com.bruno.galaxy.planets.application.usecases;

import com.bruno.galaxy.planets.domain.model.Planet;
import com.bruno.galaxy.planets.domain.ports.in.CreatePlanetUseCase;
import com.bruno.galaxy.planets.domain.ports.out.PlanetRepositoryPort;

public class CreatePlanetUseCaseImpl implements CreatePlanetUseCase {

    private final PlanetRepositoryPort planetRepositoryPort;

    public CreatePlanetUseCaseImpl(PlanetRepositoryPort planetRepositoryPort) {
        this.planetRepositoryPort = planetRepositoryPort;
    }

    @Override
    public Planet createPlanet(Planet planet) {
        return planetRepositoryPort.save(planet);
    }
}
