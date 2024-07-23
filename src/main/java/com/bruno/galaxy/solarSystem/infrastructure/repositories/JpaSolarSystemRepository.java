package com.bruno.galaxy.solarSystem.infrastructure.repositories;

import com.bruno.galaxy.solarSystem.infrastructure.entities.SolarSystemEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSolarSystemRepository extends JpaRepository<SolarSystemEntity, Long> {

    @Query("SELECT s FROM SolarSystemEntity s LEFT JOIN FETCH s.posPlanetDays WHERE s.solarDate = :solarDate")
    Optional<SolarSystemEntity> findBySolarDateWithPosPlanetDays(@Param("solarDate") Long solarDate);
  
    @Query(value = "SELECT s.* FROM solar_system s " +
                   "ORDER BY s.rain_factor DESC LIMIT 1", nativeQuery = true)
    Optional<SolarSystemEntity> findSolarSystemWithMaxPerimeter();

    @Query("SELECT s.solarDate FROM SolarSystemEntity s WHERE s.rainyDay = true")
    List<Long> findAllRainyDays();

    @Query("SELECT s.solarDate FROM SolarSystemEntity s WHERE s.drought = true")
    List<Long> findAllDroughtDays();
}
