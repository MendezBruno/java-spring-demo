package com.bruno.galaxy.planets.domain.model;

public class Planet {

    private Long id;
    private Integer angularVelocity;
    private Integer orbitKm;
    private boolean clockwise;

    public Planet () {}

    public Planet(Long id, Integer angularVelocity, Integer orbitKm, boolean clockwise) {
        this.id = id;
        this.angularVelocity = angularVelocity;
        this.orbitKm = orbitKm;
        this.clockwise = clockwise;
    }

    // Getters and setters

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
   
    public Long[] getPosition(long day) {
        double angle = angularVelocity * day;
        if (!clockwise) {
            angle = -angle;
        }
        // Convertir grados a radianes
        double radians = Math.toRadians(angle % 360);
        Long x = Math.round(orbitKm * Math.cos(radians));
        Long y = Math.round(orbitKm * Math.sin(radians));
        return new Long[]{x, y};
    }
}
