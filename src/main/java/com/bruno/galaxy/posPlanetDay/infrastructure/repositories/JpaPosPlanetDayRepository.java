package com.bruno.galaxy.posPlanetDay.infrastructure.repositories;

import com.bruno.galaxy.posPlanetDay.infrastructure.entities.PosPlanetDayEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPosPlanetDayRepository extends JpaRepository<PosPlanetDayEntity, Long> {

    @Query("SELECT p FROM PosPlanetDayEntity p WHERE p.idPlanet = :planetId")
    List<PosPlanetDayEntity> findAllByPlanetId(@Param("planetId") Long planetId);

    List<PosPlanetDayEntity> findBySolarDate(Long date);

}
