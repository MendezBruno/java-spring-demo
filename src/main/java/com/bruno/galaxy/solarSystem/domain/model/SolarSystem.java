package com.bruno.galaxy.solarSystem.domain.model;


import java.util.Objects;

public class SolarSystem {

    private Long id;
    private Long solarDate;
    private boolean rainyDay;
    private boolean drought;
    private boolean cnpt;
    private double rainFactor;

    public SolarSystem() {}

    public SolarSystem(Long id,  Long solarDate, boolean rainyDay, boolean drought, boolean cnpt, double rainFactor) {
        this.id = id;
        this.solarDate = solarDate;
        this.rainyDay = rainyDay;
        this.drought = drought;
        this.cnpt = cnpt;
        this.rainFactor = rainFactor;
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

    public double getRainFactor() {
        return rainFactor;
    }

    public void setRainFactor(double rainFactor) {
        this.rainFactor = rainFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolarSystem that = (SolarSystem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
