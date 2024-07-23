package com.bruno.galaxy.posPlanetDay.application.usecases;

import com.bruno.galaxy.posPlanetDay.domain.ports.in.DeletePosPlanetDayUseCase;
import com.bruno.galaxy.posPlanetDay.domain.ports.out.PosPlanetDayRepositoryPort;

public class DeletePosPlanetDayUseCaseImpl implements DeletePosPlanetDayUseCase {

    private final PosPlanetDayRepositoryPort posPlanetDayRepositoryPort;

    public DeletePosPlanetDayUseCaseImpl(PosPlanetDayRepositoryPort posPlanetDayRepositoryPort) {
        this.posPlanetDayRepositoryPort = posPlanetDayRepositoryPort;
    }

    @Override
    public boolean deletePosPlanetDay(Long id) {
        return posPlanetDayRepositoryPort.deleteById(id);
    }
}
