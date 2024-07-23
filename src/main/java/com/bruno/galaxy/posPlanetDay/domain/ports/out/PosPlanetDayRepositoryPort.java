package com.bruno.galaxy.posPlanetDay.domain.ports.out;

import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;

import java.util.List;
import java.util.Optional;

public interface PosPlanetDayRepositoryPort {
    PosPlanetDay save(PosPlanetDay posPlanetDay);
    List<PosPlanetDay> createAllPosPlanetDay(List<PosPlanetDay> posPlanetDay);
    Optional<PosPlanetDay> findById(Long id);
    List<PosPlanetDay> findAll();
    Optional<PosPlanetDay> update(PosPlanetDay posPlanetDay);
    boolean deleteById(Long id);
    List<PosPlanetDay> findAllByPlanetId(Long planetId);
}
