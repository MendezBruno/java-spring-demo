package com.bruno.galaxy.planets.infrastructure.repositories;

import com.bruno.galaxy.planets.domain.model.Planet;
import com.bruno.galaxy.planets.domain.ports.out.PlanetRepositoryPort;
import com.bruno.galaxy.planets.infrastructure.entities.PlanetEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaPlanetRepositoryAdapter implements PlanetRepositoryPort {

    private final JpaPlanetRepository jpaPlanetRepository;

    public JpaPlanetRepositoryAdapter(JpaPlanetRepository jpaPlanetRepository) {
        this.jpaPlanetRepository = jpaPlanetRepository;
    }

    @Override
    public Planet save(Planet planet) {
        PlanetEntity planetEntity = PlanetEntity.fromDomainModel(planet);
        PlanetEntity savedPlanetEntity = jpaPlanetRepository.save(planetEntity);
        return savedPlanetEntity.toDomainModel();
    }

    @Override
    public Optional<Planet> findById(Long id) {
        return jpaPlanetRepository.findById(id).map(PlanetEntity::toDomainModel);
    }

    @Override
    public List<Planet> findAll() {
        return jpaPlanetRepository.findAll().stream()
                .map(PlanetEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Planet> update(Planet planet) {
        if (jpaPlanetRepository.existsById(planet.getId())) {
            PlanetEntity planetEntity = PlanetEntity.fromDomainModel(planet);
            PlanetEntity updatedPlanetEntity = jpaPlanetRepository.save(planetEntity);
            return Optional.of(updatedPlanetEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaPlanetRepository.existsById(id)) {
            jpaPlanetRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
