package com.bruno.galaxy.period.domain.ports.out;

import com.bruno.galaxy.period.domain.model.Period;

import java.util.List;
import java.util.Optional;

public interface PeriodRepositoryPort {
    Period save(Period period);
    List<Period> createAllPeriod(List<Period> period);
    Optional<Period> findById(Long id);
    List<Period> findAll();
    Optional<Period> update(Period period);
    boolean deleteById(Long id);
    List<Period> findByWheaterCondition(String wheaterCondition);
}
