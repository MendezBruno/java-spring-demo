package com.bruno.galaxy.solarSystem.application.usecases;

import com.bruno.galaxy.solarSystem.domain.ports.in.DeleteSolarSystemUseCase;
import com.bruno.galaxy.solarSystem.domain.ports.out.SolarSystemRepositoryPort;

public class DeleteSolarSystemUseCaseImpl implements DeleteSolarSystemUseCase {

    private final SolarSystemRepositoryPort solarSystemRepositoryPort;

    public DeleteSolarSystemUseCaseImpl(SolarSystemRepositoryPort solarSystemRepositoryPort) {
        this.solarSystemRepositoryPort = solarSystemRepositoryPort;
    }

    @Override
    public boolean deleteSolarSystem(Long id) {
        return solarSystemRepositoryPort.deleteById(id);
    }
}
