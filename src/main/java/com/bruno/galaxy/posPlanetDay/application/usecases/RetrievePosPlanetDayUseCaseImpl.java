package com.bruno.galaxy.posPlanetDay.application.usecases;

import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;
import com.bruno.galaxy.posPlanetDay.domain.ports.in.RetrievePosPlanetDayUseCase;
import com.bruno.galaxy.posPlanetDay.domain.ports.out.PosPlanetDayRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrievePosPlanetDayUseCaseImpl implements RetrievePosPlanetDayUseCase {

    private final PosPlanetDayRepositoryPort posPlanetDayRepositoryPort;

    public RetrievePosPlanetDayUseCaseImpl(PosPlanetDayRepositoryPort posPlanetDayRepositoryPort) {
        this.posPlanetDayRepositoryPort = posPlanetDayRepositoryPort;
    }

    @Override
    public Optional<PosPlanetDay> getPosPlanetDayById(Long id) {
        return posPlanetDayRepositoryPort.findById(id);
    }

    @Override
    public List<PosPlanetDay> getAllPosPlanetDay() {
        return posPlanetDayRepositoryPort.findAll();
    }

    @Override
    public List<PosPlanetDay> getAllPosPlanetDayByPlanetId(Long planetId) {
        return posPlanetDayRepositoryPort.findAllByPlanetId(planetId);
    }
}
