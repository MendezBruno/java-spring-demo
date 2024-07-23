package com.bruno.galaxy.solarSystem.application.usecases;

import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;
import com.bruno.galaxy.solarSystem.domain.ports.in.CreateSolarSystemUseCase;
import com.bruno.galaxy.solarSystem.domain.ports.out.SolarSystemRepositoryPort;

public class CreateSolarSystemUseCaseImpl implements CreateSolarSystemUseCase {

    private final SolarSystemRepositoryPort solarSystemRepositoryPort;

    public CreateSolarSystemUseCaseImpl(SolarSystemRepositoryPort solarSystemRepositoryPort) {
        this.solarSystemRepositoryPort = solarSystemRepositoryPort;
    }

    @Override
    public SolarSystem createSolarSystem(SolarSystem solarSystem) {
        return solarSystemRepositoryPort.save(solarSystem);
    }
}
