package com.bruno.galaxy.posPlanetDay.domain.model;


public class PosPlanetDay {

    private Long id;
    private Long idPlanet;
    private Long solarDate;
    private Integer currentPI;

    public PosPlanetDay() {}

    public PosPlanetDay(Long id, Long idPlanet, Long solarDate ,Integer currentPI) {
        this.id = id;
        this.idPlanet = idPlanet;
        this.solarDate = solarDate;
        this.currentPI = currentPI;
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

    public Integer getCurrentPI() {
        return currentPI;
    }

    public void setCurrentPI(Integer currentPI) {
        this.currentPI = currentPI;
    }

    public Long getSolarDate() {
        return solarDate;
    }

    public void setSolarDate(Long solarDate) {
        this.solarDate = solarDate;
    }
    

}
