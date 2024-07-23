package com.bruno.galaxy.solarSystem.domain.ports.in;

import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;

public interface CreateSolarSystemUseCase {
    SolarSystem createSolarSystem(SolarSystem solarSystem);
}
