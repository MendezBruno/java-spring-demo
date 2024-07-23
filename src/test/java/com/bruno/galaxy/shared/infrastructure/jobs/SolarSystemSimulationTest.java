package com.bruno.galaxy.shared.infrastructure.jobs;

import com.bruno.galaxy.planets.domain.model.Planet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class SolarSystemSimulationTest {

    private Planet ferengi;
    private Planet betasoide;
    private Planet vulcano;
    private SolarSystemSimulation simulation;

    @BeforeEach
    public void setUp() {
        ferengi = Mockito.mock(Planet.class);
        betasoide = Mockito.mock(Planet.class);
        vulcano = Mockito.mock(Planet.class);

        when(ferengi.getPosition(anyLong())).thenReturn(new Long[]{500L, 0L});
        when(betasoide.getPosition(anyLong())).thenReturn(new Long[]{2000L, 0L});
        when(vulcano.getPosition(anyLong())).thenReturn(new Long[]{-1000L, 0L});

        simulation = new SolarSystemSimulation(ferengi, betasoide, vulcano);
    }

    @Test
    public void testGetWeatherConditionDrought() {
        when(ferengi.getPosition(anyLong())).thenReturn(new Long[]{500L, 0L});
        when(betasoide.getPosition(anyLong())).thenReturn(new Long[]{2000L, 0L});
        when(vulcano.getPosition(anyLong())).thenReturn(new Long[]{-1000L, 0L});

        String result = simulation.getWeatherCondition(1L);
        assertEquals("Drought", result);
    }

    @Test
    public void testGetWeatherConditionOptimal() {
        when(ferengi.getPosition(anyLong())).thenReturn(new Long[]{0L, 500L});
        when(betasoide.getPosition(anyLong())).thenReturn(new Long[]{0L, 2000L});
        when(vulcano.getPosition(anyLong())).thenReturn(new Long[]{0L, -1000L});

        String result = simulation.getWeatherCondition(1L);
        assertEquals("OptimalConditions", result);
    }

    @Test
    public void testGetWeatherConditionRainy() {
        when(ferengi.getPosition(anyLong())).thenReturn(new Long[]{0L, 0L});
        when(betasoide.getPosition(anyLong())).thenReturn(new Long[]{4L, 0L});
        when(vulcano.getPosition(anyLong())).thenReturn(new Long[]{2L, 2L});

        String result = simulation.getWeatherCondition(1L);
        assertEquals("Rainy", result);
    }

    @Test
    public void testCalculatePerimeter() {
        // Calcular perímetro para el día 1
        Long perimeter = simulation.calculatePerimeter(1L);
        assertEquals( 6000, perimeter, 0.1);
    }
}
