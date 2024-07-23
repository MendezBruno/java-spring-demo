package com.bruno.galaxy.period.application.usecases;

import com.bruno.galaxy.period.domain.model.Period;
import com.bruno.galaxy.period.domain.ports.in.UpdatePeriodUseCase;
import com.bruno.galaxy.period.domain.ports.out.PeriodRepositoryPort;

import java.util.Optional;

public class UpdatePeriodUseCaseImpl implements UpdatePeriodUseCase {

    private final PeriodRepositoryPort periodRepositoryPort;

    public UpdatePeriodUseCaseImpl(PeriodRepositoryPort periodRepositoryPort) {
        this.periodRepositoryPort = periodRepositoryPort;
    }

    @Override
    public Optional<Period> updatePeriod(Long id, Period updatedPeriod) {
        return periodRepositoryPort.update(updatedPeriod);
    }
}
