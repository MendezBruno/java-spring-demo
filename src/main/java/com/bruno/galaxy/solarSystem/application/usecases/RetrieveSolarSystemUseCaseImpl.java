package com.bruno.galaxy.solarSystem.application.usecases;

import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;
import com.bruno.galaxy.solarSystem.domain.ports.in.RetrieveSolarSystemUseCase;
import com.bruno.galaxy.solarSystem.domain.ports.out.SolarSystemRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RetrieveSolarSystemUseCaseImpl implements RetrieveSolarSystemUseCase {

    private final SolarSystemRepositoryPort solarSystemRepositoryPort;

    public RetrieveSolarSystemUseCaseImpl(SolarSystemRepositoryPort solarSystemRepositoryPort) {
        this.solarSystemRepositoryPort = solarSystemRepositoryPort;
    }

    @Override
    public Optional<SolarSystem> getSolarSystemById(Long id) {
        return solarSystemRepositoryPort.findById(id);
    }

    @Override
    public List<SolarSystem> getAllSolarSystem() {
        return solarSystemRepositoryPort.findAll();
    }

    @Override 
    public Optional<SolarSystem> getSolarSystemByDate(Long solarDate) {
        return solarSystemRepositoryPort.getSolarSystemByDate(solarDate);
    }


    @Override
    public Optional<SolarSystem> findSolarSystemWithMaxPerimeter() {
        return solarSystemRepositoryPort.findSolarSystemWithMaxPerimeter();
    }

    @Override
     public List<Long> getAllRainyDays() {
        return solarSystemRepositoryPort.findAll().stream()
                .filter(SolarSystem::isRainyDay)
                .map(SolarSystem::getSolarDate)
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> getAllDroughtDays() {
        return solarSystemRepositoryPort.findAll().stream()
                .filter(SolarSystem::isDrought)
                .map(SolarSystem::getSolarDate)
                .collect(Collectors.toList());
    }

}
