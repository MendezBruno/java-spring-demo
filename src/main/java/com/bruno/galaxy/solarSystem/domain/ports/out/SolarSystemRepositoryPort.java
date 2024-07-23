package com.bruno.galaxy.solarSystem.domain.ports.out;

import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;

import java.util.List;
import java.util.Optional;

public interface SolarSystemRepositoryPort {
    SolarSystem save(SolarSystem solarSystem);
    Optional<SolarSystem> findById(Long id);
    List<SolarSystem> findAll();
    Optional<SolarSystem> update(SolarSystem solarSystem);
    boolean deleteById(Long id);
    Optional<SolarSystem> getSolarSystemByDate(Long solarDate);
    Optional<SolarSystem> findSolarSystemWithMaxPerimeter();
    List<Long> getAllDroughtDays();
    List<Long> getAllRainyDays();
    

}
