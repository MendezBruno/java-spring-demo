package com.bruno.galaxy.planets.infrastructure.entities;

import com.bruno.galaxy.planets.domain.model.Planet;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="planets")  // Nombre de la tabla en la base de datos
public class PlanetEntity {


    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id
    @GeneratedValue Long id;
    private Integer angularVelocity;
    private Integer orbitKm;
    private boolean clockwise;


    public PlanetEntity() {
    }

    

    public PlanetEntity(Long id, Integer angularVelocity, Integer orbitKm, boolean clockwise) {
        this.id = id;
        this.angularVelocity = angularVelocity;
        this.orbitKm = orbitKm;
        this.clockwise = clockwise;
    }

    public static PlanetEntity fromDomainModel(Planet planet) {
        return new PlanetEntity(planet.getId(), planet.getAngularVelocity(), planet.getOrbitKm(), planet.isClockwise());
    }

    public Planet toDomainModel() {
        return new Planet(id, angularVelocity, orbitKm, clockwise);
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAngularVelocity() {
        return angularVelocity;
    }

    public void setAngularVelocity(Integer angularVelocity) {
        this.angularVelocity = angularVelocity;
    }

    public Integer getOrbitKm() {
        return orbitKm;
    }

    public void setOrbitKm(Integer orbitKm) {
        this.orbitKm = orbitKm;
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public void setClockwise(boolean clockwise) {
        this.clockwise = clockwise;
    }

}
