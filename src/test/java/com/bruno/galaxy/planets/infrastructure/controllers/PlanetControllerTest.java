package com.bruno.galaxy.planets.infrastructure.controllers;

import com.bruno.galaxy.planets.application.services.PlanetService;
import com.bruno.galaxy.planets.domain.model.Planet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class PlanetControllerTest {

    @Mock
    private PlanetService planetService;

    @InjectMocks
    private PlanetController planetController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(planetController).build();
    }

    @Test
    public void testCreatePlanet() {
        Planet planet = new Planet();
        when(planetService.createPlanet(any(Planet.class))).thenReturn(planet);

        ResponseEntity<Planet> response = planetController.createPlanet(planet);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(planet, response.getBody());
        verify(planetService, times(1)).createPlanet(planet);
    }

    @Test
    public void testGetPlanetById() {
        Planet planet = new Planet();
        when(planetService.getPlanetById(anyLong())).thenReturn(Optional.of(planet));

        ResponseEntity<Planet> response = planetController.getPlanetById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(planet, response.getBody());
        verify(planetService, times(1)).getPlanetById(1L);
    }

    @Test
    public void testGetPlanetById_NotFound() {
        when(planetService.getPlanetById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Planet> response = planetController.getPlanetById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(planetService, times(1)).getPlanetById(1L);
    }

    @Test
    public void testGetAllPlanets() {
        Planet planet1 = new Planet();
        Planet planet2 = new Planet();
        List<Planet> planets = Arrays.asList(planet1, planet2);
        when(planetService.getAllPlanets()).thenReturn(planets);

        ResponseEntity<List<Planet>> response = planetController.getAllPlanets();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(planets, response.getBody());
        verify(planetService, times(1)).getAllPlanets();
    }

    @Test
    public void testUpdatePlanet() {
        Planet planet = new Planet();
        when(planetService.updatePlanet(anyLong(), any(Planet.class))).thenReturn(Optional.of(planet));

        ResponseEntity<Planet> response = planetController.updatePlanet(1L, planet);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(planet, response.getBody());
        verify(planetService, times(1)).updatePlanet(1L, planet);
    }

    @Test
    public void testUpdatePlanet_NotFound() {
        when(planetService.updatePlanet(anyLong(), any(Planet.class))).thenReturn(Optional.empty());

        Planet planet = new Planet();
        ResponseEntity<Planet> response = planetController.updatePlanet(1L, planet);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(planetService, times(1)).updatePlanet(1L, planet);
    }

    @Test
    public void testDeletePlanetById() {
        when(planetService.deletePlanet(anyLong())).thenReturn(true);

        ResponseEntity<Void> response = planetController.deletePlanetById(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(planetService, times(1)).deletePlanet(1L);
    }

    @Test
    public void testDeletePlanetById_NotFound() {
        when(planetService.deletePlanet(anyLong())).thenReturn(false);

        ResponseEntity<Void> response = planetController.deletePlanetById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(planetService, times(1)).deletePlanet(1L);
    }
}
