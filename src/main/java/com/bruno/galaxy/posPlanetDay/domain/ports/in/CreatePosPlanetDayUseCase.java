package com.bruno.galaxy.posPlanetDay.domain.ports.in;

import java.util.List;

import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;

public interface CreatePosPlanetDayUseCase {
    PosPlanetDay createPosPlanetDay(PosPlanetDay posPlanetDay);
    List<PosPlanetDay> createAllPosPlanetDay(List<PosPlanetDay> posPlanetDay);

}
