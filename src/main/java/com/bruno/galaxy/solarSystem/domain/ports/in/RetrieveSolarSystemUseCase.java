package com.bruno.galaxy.solarSystem.domain.ports.in;

import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;
import com.bruno.galaxy.solarSystem.infrastructure.exception.SolarSystemNotFoundException;

import java.util.List;
import java.util.Optional;

public interface RetrieveSolarSystemUseCase {
    Optional<SolarSystem> getSolarSystemById(Long id) throws SolarSystemNotFoundException;
    List<SolarSystem> getAllSolarSystem();
    Optional<SolarSystem> getSolarSystemByDate(Long solarDate) throws SolarSystemNotFoundException;
    Optional<SolarSystem> findSolarSystemWithMaxPerimeter();
    List<Long> getAllRainyDays();
    List<Long> getAllDroughtDays();

}


