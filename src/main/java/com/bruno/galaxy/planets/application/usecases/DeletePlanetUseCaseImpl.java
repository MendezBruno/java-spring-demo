package com.bruno.galaxy.planets.application.usecases;

import com.bruno.galaxy.planets.domain.ports.in.DeletePlanetUseCase;
import com.bruno.galaxy.planets.domain.ports.out.PlanetRepositoryPort;

public class DeletePlanetUseCaseImpl implements DeletePlanetUseCase {

    private final PlanetRepositoryPort planetRepositoryPort;

    public DeletePlanetUseCaseImpl(PlanetRepositoryPort planetRepositoryPort) {
        this.planetRepositoryPort = planetRepositoryPort;
    }

    @Override
    public boolean deletePlanet(Long id) {
        return planetRepositoryPort.deleteById(id);
    }
}
