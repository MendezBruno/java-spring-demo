package com.bruno.galaxy.period.application.usecases;

import java.util.List;

import com.bruno.galaxy.period.domain.model.Period;
import com.bruno.galaxy.period.domain.ports.in.CreatePeriodUseCase;
import com.bruno.galaxy.period.domain.ports.out.PeriodRepositoryPort;

public class CreatePeriodUseCaseImpl implements CreatePeriodUseCase {

    private final PeriodRepositoryPort periodRepositoryPort;

    public CreatePeriodUseCaseImpl(PeriodRepositoryPort periodRepositoryPort) {
        this.periodRepositoryPort = periodRepositoryPort;
    }

    @Override
    public Period createPeriod(Period period) {
        return periodRepositoryPort.save(period);
    }

   @Override
    public List<Period> createAllPeriod(List<Period> period) {
        return periodRepositoryPort.createAllPeriod(period);
    }
}
