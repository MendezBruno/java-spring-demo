package com.bruno.galaxy.posPlanetDay.infrastructure.entities;

import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pos_planet_day")
public class PosPlanetDayEntity {

    @Id
    @GeneratedValue
    private Long id;


    private Long idPlanet;
    private Long solarDate;
    private Integer currentPI;

    public PosPlanetDayEntity() {
    }

    public PosPlanetDayEntity(Long id, Long idPlanet, Long solarDate, Integer currentPI) {
        this.id = id;
        this.idPlanet = idPlanet;
        this.solarDate = solarDate;
        this.currentPI = currentPI;
    }

    public static PosPlanetDayEntity fromDomainModel(PosPlanetDay posPlanetDay) {
        return new PosPlanetDayEntity(posPlanetDay.getId(), posPlanetDay.getIdPlanet(), posPlanetDay.getSolarDate(), posPlanetDay.getCurrentPI());
    }

    public PosPlanetDay toDomainModel() {
        return new PosPlanetDay(id, idPlanet, solarDate, currentPI);
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPlanet() {
        return idPlanet;
    }

    public void setIdPlanet(Long idPlanet) {
        this.idPlanet = idPlanet;
    }

    public Long getSolarDate() {
        return solarDate;
    }

    public void setSolarDate(Long solarDate) {
        this.solarDate = solarDate;
    }

    public Integer getCurrentPI() {
        return currentPI;
    }

    public void setCurrentPI(Integer currentPI) {
        this.currentPI = currentPI;
    }
}
