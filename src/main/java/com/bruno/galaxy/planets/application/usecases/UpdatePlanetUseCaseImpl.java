package com.bruno.galaxy.planets.application.usecases;

import com.bruno.galaxy.planets.domain.model.Planet;
import com.bruno.galaxy.planets.domain.ports.in.UpdatePlanetUseCase;
import com.bruno.galaxy.planets.domain.ports.out.PlanetRepositoryPort;

import java.util.Optional;

public class UpdatePlanetUseCaseImpl implements UpdatePlanetUseCase {

    private final PlanetRepositoryPort planetRepositoryPort;

    public UpdatePlanetUseCaseImpl(PlanetRepositoryPort planetRepositoryPort) {
        this.planetRepositoryPort = planetRepositoryPort;
    }

    @Override
    public Optional<Planet> updatePlanet(Long id, Planet updatedPlanet) {
        return planetRepositoryPort.update(updatedPlanet);
    }
}
