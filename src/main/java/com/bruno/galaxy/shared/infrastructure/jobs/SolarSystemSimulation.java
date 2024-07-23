package com.bruno.galaxy.shared.infrastructure.jobs;

import com.bruno.galaxy.planets.domain.model.Planet;

public class SolarSystemSimulation {

    private final Planet ferengi;
    private final Planet betasoide;
    private final Planet vulcano;

    public SolarSystemSimulation() {
        this.ferengi = new Planet(1L, 1, 500, true);
        this.betasoide = new Planet(2L, 3, 2000, true);
        this.vulcano = new Planet(3L, 5, 1000, false);
    }

    public SolarSystemSimulation(Planet ferengi, Planet betasoide, Planet vulcano) {
        this.betasoide = betasoide;
        this.ferengi = ferengi;
        this.vulcano = vulcano;
    }

    public String getWeatherCondition(long day) {
        Long[] posFerengi = ferengi.getPosition(day);
        Long[] posBetasoide = betasoide.getPosition(day);
        Long[] posVulcano = vulcano.getPosition(day);

        if (areAligned(posFerengi, posBetasoide, posVulcano)) {
            if (areAlignedWithSun(posFerengi, posBetasoide)) {
                return "Drought";
            } else {
                return "OptimalConditions";
            }
        } else {
            Long triangleArea = calculateTriangleArea(posFerengi, posBetasoide, posVulcano);
            if (triangleArea == 0) {
                return "OptimalConditions";
            } else if (isSunInsideTriangle(posFerengi, posBetasoide, posVulcano)) {
                return "Rainy";
            } else {
                return "Unknown";
            }
        }
    }

    private boolean areAligned(Long[] p1, Long[] p2, Long[] p3) {
        return ((p1[1] - p2[1]) * (p1[0] - p3[0])) == ((p1[1] - p3[1]) * (p1[0] - p2[0]));
    }

    private boolean areAlignedWithSun(Long[] p1, Long[] p2) {
        if ((p1[0] == 0 && p1[1] == 0) || (p2[0] == 0 && p2[1] == 0)) {
            return true;
        }
        if (p1[0] == 0 || p2[0] == 0) {
            return false;
        }
        return (p1[1] / p1[0]) == (p2[1] / p2[0]);
    }

    private Long calculateTriangleArea(Long[] p1, Long[] p2, Long[] p3) {
        return Math.round(0.5 * Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1])));
    }

    private boolean isSunInsideTriangle(Long[] p1, Long[] p2, Long[] p3) {
        Long[] sun = { 0L, 0L };
        Long totalArea = calculateTriangleArea(p1, p2, p3);
        Long area1 = calculateTriangleArea(sun, p1, p2);
        Long area2 = calculateTriangleArea(sun, p2, p3);
        Long area3 = calculateTriangleArea(sun, p3, p1);
        return totalArea == (area1 + area2 + area3);
    }

    public Long calculatePerimeter(long day) {
        Long[] posFerengi = ferengi.getPosition(day);
        Long[] posBetasoide = betasoide.getPosition(day);
        Long[] posVulcano = vulcano.getPosition(day);

        Long d1 = calculateDistance(posFerengi, posBetasoide);
        Long d2 = calculateDistance(posBetasoide, posVulcano);
        Long d3 = calculateDistance(posVulcano, posFerengi);
        return d1 + d2 + d3;
    }

    private Long calculateDistance(Long[] p1, Long[] p2) {
        return Math.round( Math.sqrt(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2)));
    }
}
