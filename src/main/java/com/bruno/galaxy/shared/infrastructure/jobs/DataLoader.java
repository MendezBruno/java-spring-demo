package com.bruno.galaxy.shared.infrastructure.jobs;

import com.bruno.galaxy.period.application.services.PeriodService;
import com.bruno.galaxy.period.domain.model.Period;
import com.bruno.galaxy.planets.application.services.PlanetService;
import com.bruno.galaxy.planets.domain.model.Planet;
import com.bruno.galaxy.posPlanetDay.application.services.PosPlanetDayService;
import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;
import com.bruno.galaxy.solarSystem.application.services.SolarSystemService;
import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PlanetService planetService;

    @Autowired
    private SolarSystemService solarSystemService;

    @Autowired
    private PosPlanetDayService posPlanetDayService;

    @Autowired
    private PeriodService periodService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Crear planetas
        Planet ferengi = new Planet(1L, 1, 500, true);
        Planet betasoide = new Planet(2L, 3, 2000, true);
        Planet vulcano = new Planet(3L, -5, 1000, false); // -5 para indicar sentido anti-horario

        List<Long> droughtDays = new ArrayList<>();
        List<Long> rainyDays = new ArrayList<>();
        List<Long> optimalConditions = new ArrayList<>();


        planetService.createPlanet(ferengi);
        planetService.createPlanet(betasoide);
        planetService.createPlanet(vulcano);

        SolarSystemSimulation simulation = new SolarSystemSimulation();

        for (long day = 1; day <= 3650; day++) {
            String weatherCondition = simulation.getWeatherCondition(day);

            SolarSystem solarSystem = new SolarSystem(null, day, "Rainy".equals(weatherCondition), "Drought".equals(weatherCondition), "OptimalConditions".equals(weatherCondition), simulation.calculatePerimeter(day));
            solarSystemService.createSolarSystem(solarSystem);

            if ("Rainy".equals(weatherCondition)) {
                rainyDays.add(day);
            } else if ("Drought".equals(weatherCondition)) {
                droughtDays.add(day);
            } else if ("OptimalConditions".equals(weatherCondition)) {
                optimalConditions.add(day);
            }

            List<PosPlanetDay> posPlanetDays = new ArrayList<>();
            posPlanetDays.add(new PosPlanetDay(null, ferengi.getId(), day, calculatePI(day, ferengi)));
            posPlanetDays.add(new PosPlanetDay(null, betasoide.getId(), day, calculatePI(day, betasoide)));
            posPlanetDays.add(new PosPlanetDay(null, vulcano.getId(), day, calculatePI(day, vulcano)));

            posPlanetDayService.createAllPosPlanetDay(posPlanetDays);

        }

        List<Period> droughtPeriods = calculatePeriods(droughtDays, "Drought");
        periodService.createAllPeriod(droughtPeriods);

        List<Period> rainyPeriods = calculatePeriods(rainyDays, "Rainy");
        periodService.createAllPeriod(rainyPeriods);

        List<Period> cnptPeriods = calculatePeriods(optimalConditions, "OptimalConditions");
        periodService.createAllPeriod(cnptPeriods);
    }

    private List<Period> calculatePeriods(List<Long> days, String weatherCondition) {
        List<Period> periods = new ArrayList<>();
        if (days.isEmpty()) {
            return periods;
        }

        Long start = days.get(0);
        Long end = days.get(0);

        for (int i = 1; i < days.size(); i++) {
            Long currentDay = days.get(i);
            if (currentDay.equals(end + 1)) {
                end = currentDay;
            } else {
                periods.add(new Period(null, start.intValue(), end.intValue(), weatherCondition));
                start = currentDay;
                end = currentDay;
            }
        }
        periods.add(new Period(null, start.intValue(), end.intValue(), weatherCondition));

        return periods;
    }

    private int calculatePI(long day, Planet planet) {
        // Calcula el PI basado en el día y las características del planeta (puedes ajustar esta lógica según sea necesario)
        return (int) (planet.getAngularVelocity() * day % 360);
    }
}

