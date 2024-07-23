package com.bruno.galaxy.planets.application.usecases;

import com.bruno.galaxy.planets.domain.model.Planet;
import com.bruno.galaxy.planets.domain.ports.in.RetrievePlanetUseCase;
import com.bruno.galaxy.planets.domain.ports.out.PlanetRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrievePlanetUseCaseImpl implements RetrievePlanetUseCase {

    private final PlanetRepositoryPort planetRepositoryPort;

    public RetrievePlanetUseCaseImpl(PlanetRepositoryPort planetRepositoryPort) {
        this.planetRepositoryPort = planetRepositoryPort;
    }

    @Override
    public Optional<Planet> getPlanetById(Long id) {
        return planetRepositoryPort.findById(id);
    }

    @Override
    public List<Planet> getAllPlanets() {
        return planetRepositoryPort.findAll();
    }
}
