package com.bruno.galaxy.period.application.usecases;

import com.bruno.galaxy.period.domain.model.Period;
import com.bruno.galaxy.period.domain.ports.in.RetrievePeriodUseCase;
import com.bruno.galaxy.period.domain.ports.out.PeriodRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrievePeriodUseCaseImpl implements RetrievePeriodUseCase {

    private final PeriodRepositoryPort periodRepositoryPort;

    public RetrievePeriodUseCaseImpl(PeriodRepositoryPort periodRepositoryPort) {
        this.periodRepositoryPort = periodRepositoryPort;
    }

    @Override
    public Optional<Period> getPeriodById(Long id) {
        return periodRepositoryPort.findById(id);
    }

    @Override
    public List<Period> getAllPeriods() {
        return periodRepositoryPort.findAll();
    }

    @Override
    public List<Period> getPeriodsByWheaterCondition(String wheaterCondition) {
        return periodRepositoryPort.findByWheaterCondition(wheaterCondition);
    }

}
