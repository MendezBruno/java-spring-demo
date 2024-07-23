package com.bruno.galaxy.posPlanetDay.application.usecases;

import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;
import com.bruno.galaxy.posPlanetDay.domain.ports.in.UpdatePosPlanetDayUseCase;
import com.bruno.galaxy.posPlanetDay.domain.ports.out.PosPlanetDayRepositoryPort;

import java.util.Optional;

public class UpdatePosPlanetDayUseCaseImpl implements UpdatePosPlanetDayUseCase {

    private final PosPlanetDayRepositoryPort posPlanetDayRepositoryPort;

    public UpdatePosPlanetDayUseCaseImpl(PosPlanetDayRepositoryPort posPlanetDayRepositoryPort) {
        this.posPlanetDayRepositoryPort = posPlanetDayRepositoryPort;
    }

    @Override
    public Optional<PosPlanetDay> updatePosPlanetDay(Long id, PosPlanetDay updatedPosPlanetDay) {
        return posPlanetDayRepositoryPort.update(updatedPosPlanetDay);
    }
}
