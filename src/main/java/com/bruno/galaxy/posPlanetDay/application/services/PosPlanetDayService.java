package com.bruno.galaxy.posPlanetDay.application.services;

import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;
import com.bruno.galaxy.posPlanetDay.domain.ports.in.CreatePosPlanetDayUseCase;
import com.bruno.galaxy.posPlanetDay.domain.ports.in.DeletePosPlanetDayUseCase;
import com.bruno.galaxy.posPlanetDay.domain.ports.in.RetrievePosPlanetDayUseCase;
import com.bruno.galaxy.posPlanetDay.domain.ports.in.UpdatePosPlanetDayUseCase;

import java.util.List;
import java.util.Optional;

public class PosPlanetDayService implements CreatePosPlanetDayUseCase, RetrievePosPlanetDayUseCase, UpdatePosPlanetDayUseCase, DeletePosPlanetDayUseCase  {

    private final CreatePosPlanetDayUseCase createPosPlanetDayUseCase;
    private final RetrievePosPlanetDayUseCase retrievePosPlanetDayUseCase;
    private final UpdatePosPlanetDayUseCase updatePosPlanetDayUseCase;
    private final DeletePosPlanetDayUseCase deletePosPlanetDayUseCase;

    public PosPlanetDayService(CreatePosPlanetDayUseCase createPosPlanetDayUseCase, RetrievePosPlanetDayUseCase retrievePosPlanetDayUseCase,
                       UpdatePosPlanetDayUseCase updatePosPlanetDayUseCase, DeletePosPlanetDayUseCase deletePosPlanetDayUseCase) {
        this.createPosPlanetDayUseCase = createPosPlanetDayUseCase;
        this.retrievePosPlanetDayUseCase = retrievePosPlanetDayUseCase;
        this.updatePosPlanetDayUseCase = updatePosPlanetDayUseCase;
        this.deletePosPlanetDayUseCase = deletePosPlanetDayUseCase;
    }

    @Override
    public PosPlanetDay createPosPlanetDay(PosPlanetDay posPlanetDay) {
        return createPosPlanetDayUseCase.createPosPlanetDay(posPlanetDay);
    }

    @Override
    public Optional<PosPlanetDay> getPosPlanetDayById(Long id) {
        return retrievePosPlanetDayUseCase.getPosPlanetDayById(id);
    }

    @Override
    public List<PosPlanetDay> getAllPosPlanetDay() {
        return retrievePosPlanetDayUseCase.getAllPosPlanetDay();
    }

    @Override
    public Optional<PosPlanetDay> updatePosPlanetDay(Long id, PosPlanetDay updatedPosPlanetDay) {
        return updatePosPlanetDayUseCase.updatePosPlanetDay(id, updatedPosPlanetDay);
    }

    @Override
    public boolean deletePosPlanetDay(Long id) {
        return deletePosPlanetDayUseCase.deletePosPlanetDay(id);
    }

    @Override
    public List<PosPlanetDay> getAllPosPlanetDayByPlanetId(Long planetId) {
        return retrievePosPlanetDayUseCase.getAllPosPlanetDayByPlanetId(planetId);
    }

    @Override
    public List<PosPlanetDay> createAllPosPlanetDay(List<PosPlanetDay> posPlanetDays) {
        return createPosPlanetDayUseCase.createAllPosPlanetDay(posPlanetDays);
    }


}
