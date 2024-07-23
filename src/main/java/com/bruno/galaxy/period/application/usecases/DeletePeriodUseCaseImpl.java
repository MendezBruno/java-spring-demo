package com.bruno.galaxy.period.application.usecases;

import com.bruno.galaxy.period.domain.ports.in.DeletePeriodUseCase;
import com.bruno.galaxy.period.domain.ports.out.PeriodRepositoryPort;

public class DeletePeriodUseCaseImpl implements DeletePeriodUseCase {

    private final PeriodRepositoryPort periodRepositoryPort;

    public DeletePeriodUseCaseImpl(PeriodRepositoryPort periodRepositoryPort) {
        this.periodRepositoryPort = periodRepositoryPort;
    }

    @Override
    public boolean deletePeriod(Long id) {
        return periodRepositoryPort.deleteById(id);
    }
}
