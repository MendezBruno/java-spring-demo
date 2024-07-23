package com.bruno.galaxy.solarSystem.application.usecases;

import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;
import com.bruno.galaxy.solarSystem.domain.ports.in.UpdateSolarSystemUseCase;
import com.bruno.galaxy.solarSystem.domain.ports.out.SolarSystemRepositoryPort;

import java.util.Optional;

public class UpdateSolarSystemUseCaseImpl implements UpdateSolarSystemUseCase {

    private final SolarSystemRepositoryPort solarSystemRepositoryPort;

    public UpdateSolarSystemUseCaseImpl(SolarSystemRepositoryPort solarSystemRepositoryPort) {
        this.solarSystemRepositoryPort = solarSystemRepositoryPort;
    }

    @Override
    public Optional<SolarSystem> updateSolarSystem(Long id, SolarSystem updatedSolarSystem) {
        return solarSystemRepositoryPort.update(updatedSolarSystem);
    }

    public Optional<SolarSystem> getSolarSystemWithMaxPerimeter() {
        return solarSystemRepositoryPort.findSolarSystemWithMaxPerimeter();
    }
}
