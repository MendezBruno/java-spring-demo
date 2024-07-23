package com.bruno.galaxy.period.infrastructure.repositories;

import org.springframework.stereotype.Repository;

import com.bruno.galaxy.period.domain.model.Period;
import com.bruno.galaxy.period.domain.ports.out.PeriodRepositoryPort;
import com.bruno.galaxy.period.infrastructure.entities.PeriodEntity;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaPeriodRepositoryAdapter implements PeriodRepositoryPort {

    private final JpaPeriodRepository jpaPeriodRepository;

    public JpaPeriodRepositoryAdapter(JpaPeriodRepository jpaPeriodRepository) {
        this.jpaPeriodRepository = jpaPeriodRepository;
    }

    @Override
    public Period save(Period period) {
        PeriodEntity periodEntity = PeriodEntity.fromDomainModel(period);
        PeriodEntity savedPeriodEntity = jpaPeriodRepository.save(periodEntity);
        return savedPeriodEntity.toDomainModel();
    }

    @Override
    public List<Period> createAllPeriod(List<Period> period) {
        List<PeriodEntity> periodEntities = period.stream()
                .map(PeriodEntity::fromDomainModel)
                .collect(Collectors.toList());
        List<PeriodEntity> savedPeriodEntities = jpaPeriodRepository.saveAll(periodEntities);
        return savedPeriodEntities.stream()
                .map(PeriodEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Period> findById(Long id) {
        return jpaPeriodRepository.findById(id).map(PeriodEntity::toDomainModel);
    }

    @Override
    public List<Period> findAll() {
        return jpaPeriodRepository.findAll().stream()
                .map(PeriodEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Period> update(Period period) {
        if (jpaPeriodRepository.existsById(period.getId())) {
            PeriodEntity periodEntity = PeriodEntity.fromDomainModel(period);
            PeriodEntity updatedPeriodEntity = jpaPeriodRepository.save(periodEntity);
            return Optional.of(updatedPeriodEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaPeriodRepository.existsById(id)) {
            jpaPeriodRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Period> findByWheaterCondition(String wheaterCondition) {
        return jpaPeriodRepository.findByWheaterCondition(wheaterCondition).stream()
                .map(PeriodEntity::toDomainModel)
                .collect(Collectors.toList());
    }
}
