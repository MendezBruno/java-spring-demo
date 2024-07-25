package com.bruno.galaxy.posPlanetDay.domain.ports.in;

import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;

import java.util.List;
import java.util.Optional;

public interface RetrievePosPlanetDayUseCase {
    Optional<PosPlanetDay> getPosPlanetDayById(Long id);
    List<PosPlanetDay> getAllPosPlanetDay();
    List<PosPlanetDay> getAllPosPlanetDayByPlanetId(Long planetId);
    List<PosPlanetDay> getAllPosPlanetDayByDate(Long date);
}
