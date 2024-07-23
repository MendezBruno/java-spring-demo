package com.bruno.galaxy.solarSystem.domain.ports.in;

import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;
import com.bruno.galaxy.solarSystem.infrastructure.exception.SolarSystemNotFoundException;

import java.util.Optional;

public interface UpdateSolarSystemUseCase {
    Optional<SolarSystem> updateSolarSystem(Long id, SolarSystem updatedSolarSystem) throws SolarSystemNotFoundException;
}
