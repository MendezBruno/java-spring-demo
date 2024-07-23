package com.bruno.galaxy.solarSystem.infrastructure.repositories;

import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;
import com.bruno.galaxy.solarSystem.domain.ports.out.SolarSystemRepositoryPort;
import com.bruno.galaxy.solarSystem.infrastructure.entities.SolarSystemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaSolarSystemRepositoryAdapter implements SolarSystemRepositoryPort {

    private final JpaSolarSystemRepository jpaSolarSystemRepository;

    public JpaSolarSystemRepositoryAdapter(JpaSolarSystemRepository jpaSolarSystemRepository) {
        this.jpaSolarSystemRepository = jpaSolarSystemRepository;
    }

    @Override
    public SolarSystem save(SolarSystem solarSystem) {
        SolarSystemEntity solarSystemEntity = SolarSystemEntity.fromDomainModel(solarSystem);
        SolarSystemEntity savedSolarSystemEntity = jpaSolarSystemRepository.save(solarSystemEntity);
        return savedSolarSystemEntity.toDomainModel();
    }

    @Override
    public Optional<SolarSystem> findById(Long id) {
        return jpaSolarSystemRepository.findById(id).map(SolarSystemEntity::toDomainModel);
    }

    @Override
    public List<SolarSystem> findAll() {
        return jpaSolarSystemRepository.findAll().stream()
                .map(SolarSystemEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SolarSystem> update(SolarSystem solarSystem) {
        if (jpaSolarSystemRepository.existsById(solarSystem.getId())) {
            SolarSystemEntity solarSystemEntity = SolarSystemEntity.fromDomainModel(solarSystem);
            SolarSystemEntity updatedSolarSystemEntity = jpaSolarSystemRepository.save(solarSystemEntity);
            return Optional.of(updatedSolarSystemEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaSolarSystemRepository.existsById(id)) {
            jpaSolarSystemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<SolarSystem> getSolarSystemByDate(Long solarDate) {
        return jpaSolarSystemRepository.findBySolarDateWithPosPlanetDays(solarDate).map(SolarSystemEntity::toDomainModel);
    }

    @Override
    public Optional<SolarSystem> findSolarSystemWithMaxPerimeter() {
        return jpaSolarSystemRepository.findSolarSystemWithMaxPerimeter().map(SolarSystemEntity::toDomainModel);
    }

    @Override
    public List<Long> getAllDroughtDays() {
        return jpaSolarSystemRepository.findAllDroughtDays();
    }

    @Override
    public List<Long> getAllRainyDays() {
        return jpaSolarSystemRepository.findAllRainyDays();
    }

    

    
}
