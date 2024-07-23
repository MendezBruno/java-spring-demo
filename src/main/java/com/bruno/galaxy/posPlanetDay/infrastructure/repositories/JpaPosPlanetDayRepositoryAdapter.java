package com.bruno.galaxy.posPlanetDay.infrastructure.repositories;

import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;
import com.bruno.galaxy.posPlanetDay.domain.ports.out.PosPlanetDayRepositoryPort;
import com.bruno.galaxy.posPlanetDay.infrastructure.entities.PosPlanetDayEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaPosPlanetDayRepositoryAdapter implements PosPlanetDayRepositoryPort {

    private final JpaPosPlanetDayRepository jpaPosPlanetDayRepository;

    public JpaPosPlanetDayRepositoryAdapter(JpaPosPlanetDayRepository jpaPosPlanetDayRepository) {
        this.jpaPosPlanetDayRepository = jpaPosPlanetDayRepository;
    }

    @Override
    public PosPlanetDay save(PosPlanetDay posPlanetDay) {
        PosPlanetDayEntity posPlanetDayEntity = PosPlanetDayEntity.fromDomainModel(posPlanetDay);
        PosPlanetDayEntity savedPosPlanetDayEntity = jpaPosPlanetDayRepository.save(posPlanetDayEntity);
        return savedPosPlanetDayEntity.toDomainModel();
    }

    @Override
    public Optional<PosPlanetDay> findById(Long id) {
        return jpaPosPlanetDayRepository.findById(id).map(PosPlanetDayEntity::toDomainModel);
    }

    @Override
    public List<PosPlanetDay> findAll() {
        return jpaPosPlanetDayRepository.findAll().stream()
                .map(PosPlanetDayEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PosPlanetDay> update(PosPlanetDay posPlanetDay) {
        if (jpaPosPlanetDayRepository.existsById(posPlanetDay.getId())) {
            PosPlanetDayEntity posPlanetDayEntity = PosPlanetDayEntity.fromDomainModel(posPlanetDay);
            PosPlanetDayEntity updatedPosPlanetDayEntity = jpaPosPlanetDayRepository.save(posPlanetDayEntity);
            return Optional.of(updatedPosPlanetDayEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaPosPlanetDayRepository.existsById(id)) {
            jpaPosPlanetDayRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<PosPlanetDay> findAllByPlanetId(Long planetId) {
        return jpaPosPlanetDayRepository.findAllByPlanetId(planetId).stream()
                .map(PosPlanetDayEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<PosPlanetDay> createAllPosPlanetDay(List<PosPlanetDay> posPlanetDay) {
        List<PosPlanetDayEntity> posPlanetDayEntities = posPlanetDay.stream()
                .map(PosPlanetDayEntity::fromDomainModel)
                .collect(Collectors.toList());
        List<PosPlanetDayEntity> savedPosPlanetDayEntities = jpaPosPlanetDayRepository.saveAll(posPlanetDayEntities);
        return savedPosPlanetDayEntities.stream()
                .map(PosPlanetDayEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    
}
