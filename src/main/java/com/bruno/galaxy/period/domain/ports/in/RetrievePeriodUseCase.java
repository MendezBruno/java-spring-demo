package com.bruno.galaxy.period.domain.ports.in;

import com.bruno.galaxy.period.domain.model.Period;

import java.util.List;
import java.util.Optional;

public interface RetrievePeriodUseCase {
    Optional<Period> getPeriodById(Long id);
    List<Period> getAllPeriods();
    List<Period> getPeriodsByWheaterCondition(String wheaterCondition);

}
