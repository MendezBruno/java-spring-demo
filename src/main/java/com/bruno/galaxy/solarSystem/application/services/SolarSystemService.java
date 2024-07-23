package com.bruno.galaxy.solarSystem.application.services;

import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;
import com.bruno.galaxy.solarSystem.domain.ports.in.CreateSolarSystemUseCase;
import com.bruno.galaxy.solarSystem.domain.ports.in.DeleteSolarSystemUseCase;
import com.bruno.galaxy.solarSystem.domain.ports.in.RetrieveSolarSystemUseCase;
import com.bruno.galaxy.solarSystem.domain.ports.in.UpdateSolarSystemUseCase;
import com.bruno.galaxy.solarSystem.infrastructure.exception.SolarSystemNotFoundException;

import java.util.List;
import java.util.Optional;

public class SolarSystemService implements CreateSolarSystemUseCase, RetrieveSolarSystemUseCase, UpdateSolarSystemUseCase, DeleteSolarSystemUseCase  {


    private final CreateSolarSystemUseCase createSolarSystemUseCase;
    private final RetrieveSolarSystemUseCase retrieveSolarSystemUseCase;
    private final UpdateSolarSystemUseCase updateSolarSystemUseCase;
    private final DeleteSolarSystemUseCase deleteSolarSystemUseCase;

    public SolarSystemService(CreateSolarSystemUseCase createSolarSystemUseCase, RetrieveSolarSystemUseCase retrieveSolarSystemUseCase,
                              UpdateSolarSystemUseCase updateSolarSystemUseCase, DeleteSolarSystemUseCase deleteSolarSystemUseCase) {
        this.createSolarSystemUseCase = createSolarSystemUseCase;
        this.retrieveSolarSystemUseCase = retrieveSolarSystemUseCase;
        this.updateSolarSystemUseCase = updateSolarSystemUseCase;
        this.deleteSolarSystemUseCase = deleteSolarSystemUseCase;
    }

    @Override
    public SolarSystem createSolarSystem(SolarSystem solarSystem) {
        return createSolarSystemUseCase.createSolarSystem(solarSystem);
    }

    @Override
    public Optional<SolarSystem> getSolarSystemById(Long id) {
        return Optional.ofNullable(retrieveSolarSystemUseCase.getSolarSystemById(id)
                .orElseThrow(() -> new SolarSystemNotFoundException("Solar system with id " + id + " not found")));
    }

    @Override
    public List<SolarSystem> getAllSolarSystem() {
        return retrieveSolarSystemUseCase.getAllSolarSystem();
    }

    @Override
    public Optional<SolarSystem> updateSolarSystem(Long id, SolarSystem updatedSolarSystem) {
        return Optional.ofNullable(updateSolarSystemUseCase.updateSolarSystem(id, updatedSolarSystem)
                .orElseThrow(() -> new SolarSystemNotFoundException("Solar system with id " + id + " not found")));
    }

    @Override
    public boolean deleteSolarSystem(Long id) {
        if (!deleteSolarSystemUseCase.deleteSolarSystem(id)) {
            throw new SolarSystemNotFoundException("Solar system with id " + id + " not found");
        }
        return true;
    }

    @Override
    public Optional<SolarSystem> getSolarSystemByDate(Long solarDate) {
        return Optional.ofNullable(retrieveSolarSystemUseCase.getSolarSystemByDate(solarDate)
                .orElseThrow(() -> new SolarSystemNotFoundException("Solar system with date " + solarDate + " not found")));
    }

    @Override
    public Optional<SolarSystem> findSolarSystemWithMaxPerimeter() {
        return retrieveSolarSystemUseCase.findSolarSystemWithMaxPerimeter();
    }

    @Override
    public List<Long> getAllRainyDays() {
        return retrieveSolarSystemUseCase.getAllRainyDays();
    }

    @Override
    public List<Long> getAllDroughtDays() {
        return retrieveSolarSystemUseCase.getAllDroughtDays();
    }

}
