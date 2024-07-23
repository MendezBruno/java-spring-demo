package com.bruno.galaxy.shared.infrastructure.config;

import com.bruno.galaxy.period.application.services.PeriodService;
import com.bruno.galaxy.period.application.usecases.CreatePeriodUseCaseImpl;
import com.bruno.galaxy.period.application.usecases.DeletePeriodUseCaseImpl;
import com.bruno.galaxy.period.application.usecases.RetrievePeriodUseCaseImpl;
import com.bruno.galaxy.period.application.usecases.UpdatePeriodUseCaseImpl;
import com.bruno.galaxy.period.domain.ports.out.PeriodRepositoryPort;
import com.bruno.galaxy.period.infrastructure.repositories.JpaPeriodRepositoryAdapter;
import com.bruno.galaxy.planets.application.services.PlanetService;
import com.bruno.galaxy.planets.application.usecases.CreatePlanetUseCaseImpl;
import com.bruno.galaxy.planets.application.usecases.DeletePlanetUseCaseImpl;
import com.bruno.galaxy.planets.application.usecases.RetrievePlanetUseCaseImpl;
import com.bruno.galaxy.planets.application.usecases.UpdatePlanetUseCaseImpl;
import com.bruno.galaxy.planets.domain.ports.out.PlanetRepositoryPort;
import com.bruno.galaxy.planets.infrastructure.repositories.JpaPlanetRepositoryAdapter;
import com.bruno.galaxy.posPlanetDay.application.services.PosPlanetDayService;
import com.bruno.galaxy.posPlanetDay.application.usecases.CreatePosPlanetDayUseCaseImpl;
import com.bruno.galaxy.posPlanetDay.application.usecases.DeletePosPlanetDayUseCaseImpl;
import com.bruno.galaxy.posPlanetDay.application.usecases.RetrievePosPlanetDayUseCaseImpl;
import com.bruno.galaxy.posPlanetDay.application.usecases.UpdatePosPlanetDayUseCaseImpl;
import com.bruno.galaxy.posPlanetDay.domain.ports.out.PosPlanetDayRepositoryPort;
import com.bruno.galaxy.posPlanetDay.infrastructure.repositories.JpaPosPlanetDayRepositoryAdapter;
import com.bruno.galaxy.solarSystem.application.services.SolarSystemService;
import com.bruno.galaxy.solarSystem.application.usecases.*;
import com.bruno.galaxy.solarSystem.domain.ports.out.SolarSystemRepositoryPort;
import com.bruno.galaxy.solarSystem.infrastructure.repositories.JpaSolarSystemRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public SolarSystemRepositoryPort solarSystemRepositoryPort(JpaSolarSystemRepositoryAdapter jpaSolarSystemRepositoryAdapter) {
        return jpaSolarSystemRepositoryAdapter;
    }

    @Bean
    public SolarSystemService solarSystemService(SolarSystemRepositoryPort solarSystemRepositoryPort) {
        return new SolarSystemService(
                new CreateSolarSystemUseCaseImpl(solarSystemRepositoryPort),
                new RetrieveSolarSystemUseCaseImpl(solarSystemRepositoryPort),
                new UpdateSolarSystemUseCaseImpl(solarSystemRepositoryPort),
                new DeleteSolarSystemUseCaseImpl(solarSystemRepositoryPort)
        );
    }

    @Bean
    public PlanetRepositoryPort planetRepositoryPort(JpaPlanetRepositoryAdapter jpaPlanetRepositoryAdapter) {
        return jpaPlanetRepositoryAdapter;
    }

    @Bean
    public PlanetService planetService(PlanetRepositoryPort planetRepositoryPort) {
        return new PlanetService(
                new CreatePlanetUseCaseImpl(planetRepositoryPort),
                new RetrievePlanetUseCaseImpl(planetRepositoryPort),
                new UpdatePlanetUseCaseImpl(planetRepositoryPort),
                new DeletePlanetUseCaseImpl(planetRepositoryPort)
        );
    }

    @Bean
    public PosPlanetDayRepositoryPort posPlanetDayRepositoryPort(JpaPosPlanetDayRepositoryAdapter jpaPosPlanetDayRepositoryAdapter) {
        return jpaPosPlanetDayRepositoryAdapter;
    }

    @Bean
    public PosPlanetDayService posPlanetDayService(PosPlanetDayRepositoryPort posPlanetDayRepositoryPort) {
        return new PosPlanetDayService(
                new CreatePosPlanetDayUseCaseImpl(posPlanetDayRepositoryPort),
                new RetrievePosPlanetDayUseCaseImpl(posPlanetDayRepositoryPort),
                new UpdatePosPlanetDayUseCaseImpl(posPlanetDayRepositoryPort),
                new DeletePosPlanetDayUseCaseImpl(posPlanetDayRepositoryPort)
        );
    }

    @Bean
    public PeriodRepositoryPort periodRepositoryPort(JpaPeriodRepositoryAdapter jpaPeriodRepositoryAdapter) {
        return jpaPeriodRepositoryAdapter;
    }

    @Bean
    public PeriodService periodService(PeriodRepositoryPort periodRepositoryPort) {
        return new PeriodService(
                new CreatePeriodUseCaseImpl(periodRepositoryPort),
                new RetrievePeriodUseCaseImpl(periodRepositoryPort),
                new UpdatePeriodUseCaseImpl(periodRepositoryPort),
                new DeletePeriodUseCaseImpl(periodRepositoryPort)
        );
    }


}
