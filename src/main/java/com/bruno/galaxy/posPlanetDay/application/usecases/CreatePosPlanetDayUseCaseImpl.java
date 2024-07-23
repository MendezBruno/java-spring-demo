package com.bruno.galaxy.posPlanetDay.application.usecases;

import java.util.List;

import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;
import com.bruno.galaxy.posPlanetDay.domain.ports.in.CreatePosPlanetDayUseCase;
import com.bruno.galaxy.posPlanetDay.domain.ports.out.PosPlanetDayRepositoryPort;

public class CreatePosPlanetDayUseCaseImpl implements CreatePosPlanetDayUseCase {

    private final PosPlanetDayRepositoryPort posPlanetDayRepositoryPort;

    public CreatePosPlanetDayUseCaseImpl(PosPlanetDayRepositoryPort posPlanetDayRepositoryPort) {
        this.posPlanetDayRepositoryPort = posPlanetDayRepositoryPort;
    }

    @Override
    public PosPlanetDay createPosPlanetDay(PosPlanetDay posPlanetDay) {
        return posPlanetDayRepositoryPort.save(posPlanetDay);
    }

    @Override
    public List<PosPlanetDay> createAllPosPlanetDay(List<PosPlanetDay> posPlanetDay) {
        return posPlanetDayRepositoryPort.createAllPosPlanetDay(posPlanetDay);
    }
}
