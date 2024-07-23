package com.bruno.galaxy.period.application.services;

import java.util.List;
import java.util.Optional;

import com.bruno.galaxy.period.domain.model.Period;
import com.bruno.galaxy.period.domain.ports.in.CreatePeriodUseCase;
import com.bruno.galaxy.period.domain.ports.in.DeletePeriodUseCase;
import com.bruno.galaxy.period.domain.ports.in.RetrievePeriodUseCase;
import com.bruno.galaxy.period.domain.ports.in.UpdatePeriodUseCase;
public class PeriodService implements CreatePeriodUseCase, RetrievePeriodUseCase, UpdatePeriodUseCase, DeletePeriodUseCase  {

    private final CreatePeriodUseCase createPeriodUseCase;
    private final RetrievePeriodUseCase retrievePeriodUseCase;
    private final UpdatePeriodUseCase updatePeriodUseCase;
    private final DeletePeriodUseCase deletePeriodUseCase;

    public PeriodService(CreatePeriodUseCase createPeriodUseCase, RetrievePeriodUseCase retrievePeriodUseCase,
                       UpdatePeriodUseCase updatePeriodUseCase, DeletePeriodUseCase deletePeriodUseCase) {
        this.createPeriodUseCase = createPeriodUseCase;
        this.retrievePeriodUseCase = retrievePeriodUseCase;
        this.updatePeriodUseCase = updatePeriodUseCase;
        this.deletePeriodUseCase = deletePeriodUseCase;
    }

    @Override
    public Period createPeriod(Period period) {
        return createPeriodUseCase.createPeriod(period);
    }

    @Override
    public List<Period> createAllPeriod(List<Period> period) {
        return createPeriodUseCase.createAllPeriod(period);
    }

    @Override
    public Optional<Period> getPeriodById(Long id) {
        return retrievePeriodUseCase.getPeriodById(id);
    }

    @Override
    public List<Period> getAllPeriods() {
        return retrievePeriodUseCase.getAllPeriods();
    }

    @Override
    public Optional<Period> updatePeriod(Long id, Period updatedPeriod) {
        return updatePeriodUseCase.updatePeriod(id, updatedPeriod);
    }

    @Override
    public boolean deletePeriod(Long id) {
        return deletePeriodUseCase.deletePeriod(id);
    }

    @Override
    public List<Period> getPeriodsByWheaterCondition(String wheaterCondition) {
        return retrievePeriodUseCase.getPeriodsByWheaterCondition(wheaterCondition);
    }

}
