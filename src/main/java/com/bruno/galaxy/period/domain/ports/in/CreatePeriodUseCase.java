package com.bruno.galaxy.period.domain.ports.in;

import java.util.List;

import com.bruno.galaxy.period.domain.model.Period;

public interface CreatePeriodUseCase {
    Period createPeriod(Period period);
    List<Period> createAllPeriod(List<Period> period);
}
