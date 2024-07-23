package com.bruno.galaxy.solarSystem.infrastructure.entities;

import jakarta.persistence.*;
import java.util.List;

import com.bruno.galaxy.planets.infrastructure.entities.PlanetEntity;
import com.bruno.galaxy.posPlanetDay.infrastructure.entities.PosPlanetDayEntity;
import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;

@Entity
@Table(name="solar_system")
public class SolarSystemEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long solarDate;
    private boolean rainyDay;
    private boolean drought;
    private boolean cnpt;
    private double rainFactor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "solarSystem_id")
    private List<PosPlanetDayEntity> posPlanetDays;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "solarSystem_id")
    private List<PlanetEntity> planetEntities;

    public SolarSystemEntity() {
    }

    public SolarSystemEntity(Long id, Long solarDate, boolean rainyDay, boolean drought, boolean cnpt, double rainFactor) {
        this.id = id;
        this.solarDate = solarDate;
        this.rainyDay = rainyDay;
        this.drought = drought;
        this.cnpt = cnpt;
        this.rainFactor = rainFactor;
    }

    public static SolarSystemEntity fromDomainModel(SolarSystem solarSystem) {
        return new SolarSystemEntity(solarSystem.getId(), solarSystem.getSolarDate(), solarSystem.isRainyDay(), solarSystem.isDrought(), solarSystem.getCnpt(), solarSystem.getRainFactor());
    }

    public SolarSystem toDomainModel() {
        return new SolarSystem(id, solarDate, rainyDay, drought, cnpt, rainFactor);
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSolarDate() {
        return solarDate;
    }

    public void setSolarDate(Long solarDate) {
        this.solarDate = solarDate;
    }

    public boolean isRainyDay() {
        return rainyDay;
    }

    public void setRainyDay(boolean rainyDay) {
        this.rainyDay = rainyDay;
    }

    public boolean isDrought() {
        return drought;
    }

    public void setDrought(boolean drought) {
        this.drought = drought;
    }

    public boolean getCnpt() {
        return cnpt;
    }

    public void setCnpt(boolean cnpt) {
        this.cnpt = cnpt;
    }

    public List<PosPlanetDayEntity> getPosPlanetDays() {
        return posPlanetDays;
    }

    public void setPosPlanetDays(List<PosPlanetDayEntity> posPlanetDays) {
        this.posPlanetDays = posPlanetDays;
    }
    
    public double getRainFactor() {
        return rainFactor;
    }

    public void setRainFactor(double rainFactor) {
        this.rainFactor = rainFactor;
    }
}
