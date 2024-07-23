package com.bruno.galaxy.period.domain.ports.in;

import com.bruno.galaxy.period.domain.model.Period;

import java.util.Optional;

public interface UpdatePeriodUseCase {
    Optional<Period> updatePeriod(Long id, Period updatedPeriod);
}
