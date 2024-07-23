package com.bruno.galaxy.posPlanetDay.domain.ports.in;

import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;

import java.util.Optional;

public interface UpdatePosPlanetDayUseCase {
    Optional<PosPlanetDay> updatePosPlanetDay(Long id, PosPlanetDay updatedPosPlanetDay);
}
