package com.bruno.galaxy.planets.application.services;

import com.bruno.galaxy.planets.domain.model.Planet;
import com.bruno.galaxy.planets.domain.ports.in.CreatePlanetUseCase;
import com.bruno.galaxy.planets.domain.ports.in.DeletePlanetUseCase;
import com.bruno.galaxy.planets.domain.ports.in.RetrievePlanetUseCase;
import com.bruno.galaxy.planets.domain.ports.in.UpdatePlanetUseCase;

import java.util.List;
import java.util.Optional;
public class PlanetService implements CreatePlanetUseCase, RetrievePlanetUseCase, UpdatePlanetUseCase, DeletePlanetUseCase  {

    private final CreatePlanetUseCase createPlanetUseCase;
    private final RetrievePlanetUseCase retrievePlanetUseCase;
    private final UpdatePlanetUseCase updatePlanetUseCase;
    private final DeletePlanetUseCase deletePlanetUseCase;

    public PlanetService(CreatePlanetUseCase createPlanetUseCase, RetrievePlanetUseCase retrievePlanetUseCase,
                       UpdatePlanetUseCase updatePlanetUseCase, DeletePlanetUseCase deletePlanetUseCase) {
        this.createPlanetUseCase = createPlanetUseCase;
        this.retrievePlanetUseCase = retrievePlanetUseCase;
        this.updatePlanetUseCase = updatePlanetUseCase;
        this.deletePlanetUseCase = deletePlanetUseCase;
    }

    @Override
    public Planet createPlanet(Planet planet) {
        return createPlanetUseCase.createPlanet(planet);
    }

    @Override
    public Optional<Planet> getPlanetById(Long id) {
        return retrievePlanetUseCase.getPlanetById(id);
    }

    @Override
    public List<Planet> getAllPlanets() {
        return retrievePlanetUseCase.getAllPlanets();
    }

    @Override
    public Optional<Planet> updatePlanet(Long id, Planet updatedPlanet) {
        return updatePlanetUseCase.updatePlanet(id, updatedPlanet);
    }

    @Override
    public boolean deletePlanet(Long id) {
        return deletePlanetUseCase.deletePlanet(id);
    }

}
