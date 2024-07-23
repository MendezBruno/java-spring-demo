package com.bruno.galaxy.solarSystem.infrastructure.controllers;

import com.bruno.galaxy.solarSystem.application.services.SolarSystemService;
import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;
import com.bruno.galaxy.solarSystem.infrastructure.exception.SolarSystemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class SolarSystemControllerTest {

    @Mock
    private SolarSystemService solarSystemService;

    @InjectMocks
    private SolarSystemController solarSystemController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateSolarSystem() {
        SolarSystem solarSystem = new SolarSystem();
        when(solarSystemService.createSolarSystem(any(SolarSystem.class))).thenReturn(solarSystem);

        ResponseEntity<SolarSystem> response = solarSystemController.createSolarSystem(solarSystem);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(solarSystem, response.getBody());
        verify(solarSystemService, times(1)).createSolarSystem(solarSystem);
    }

    @Test
    public void testGetSolarSystemById() {
        SolarSystem solarSystem = new SolarSystem();
        when(solarSystemService.getSolarSystemById(anyLong())).thenReturn(Optional.of(solarSystem));

        ResponseEntity<SolarSystem> response = solarSystemController.getSolarSystemById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(solarSystem, response.getBody());
        verify(solarSystemService, times(1)).getSolarSystemById(1L);
    }

    @Test
    public void testGetSolarSystemById_NotFound() {
        when(solarSystemService.getSolarSystemById(anyLong())).thenReturn(Optional.empty());

        try {
            solarSystemController.getSolarSystemById(1L);
        } catch (SolarSystemNotFoundException ex) {
            assertEquals("Solar system not found with id: 1", ex.getMessage());
        }

        verify(solarSystemService, times(1)).getSolarSystemById(1L);
    }

    @Test
    public void testGetAllSolarSystem() {
        SolarSystem solarSystem1 = new SolarSystem();
        SolarSystem solarSystem2 = new SolarSystem();
        List<SolarSystem> solarSystems = Arrays.asList(solarSystem1, solarSystem2);
        when(solarSystemService.getAllSolarSystem()).thenReturn(solarSystems);

        ResponseEntity<List<SolarSystem>> response = solarSystemController.getAllSolarSystem();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(solarSystems, response.getBody());
        verify(solarSystemService, times(1)).getAllSolarSystem();
    }

    @Test
    public void testUpdateSolarSystem() {
        SolarSystem solarSystem = new SolarSystem();
        when(solarSystemService.updateSolarSystem(anyLong(), any(SolarSystem.class))).thenReturn(Optional.of(solarSystem));

        ResponseEntity<SolarSystem> response = solarSystemController.updateSolarSystem(1L, solarSystem);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(solarSystem, response.getBody());
        verify(solarSystemService, times(1)).updateSolarSystem(1L, solarSystem);
    }

    @Test
    public void testUpdateSolarSystem_NotFound() {
        when(solarSystemService.updateSolarSystem(anyLong(), any(SolarSystem.class))).thenReturn(Optional.empty());

        try {
            solarSystemController.updateSolarSystem(1L, new SolarSystem());
        } catch (SolarSystemNotFoundException ex) {
            assertEquals("Solar system not found with id: 1", ex.getMessage());
        }

        verify(solarSystemService, times(1)).updateSolarSystem(1L, new SolarSystem());
    }

    @Test
    public void testDeleteSolarSystemById() {
        when(solarSystemService.deleteSolarSystem(anyLong())).thenReturn(true);

        ResponseEntity<Void> response = solarSystemController.deleteSolarSystemById(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(solarSystemService, times(1)).deleteSolarSystem(1L);
    }

    @Test
    public void testDeleteSolarSystemById_NotFound() {
        when(solarSystemService.deleteSolarSystem(anyLong())).thenReturn(false);

        try {
            solarSystemController.deleteSolarSystemById(1L);
        } catch (SolarSystemNotFoundException ex) {
            assertEquals("Solar system not found with id: 1", ex.getMessage());
        }

        verify(solarSystemService, times(1)).deleteSolarSystem(1L);
    }

    @Test
    public void testGetSolarSystemByDate() {
        SolarSystem solarSystem = new SolarSystem();
        when(solarSystemService.getSolarSystemByDate(anyLong())).thenReturn(Optional.of(solarSystem));

        ResponseEntity<SolarSystem> response = solarSystemController.getSolarSystemByDate(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(solarSystem, response.getBody());
        verify(solarSystemService, times(1)).getSolarSystemByDate(1L);
    }

    @Test
    public void testGetSolarSystemByDate_NotFound() {
        when(solarSystemService.getSolarSystemByDate(anyLong())).thenReturn(Optional.empty());

        try {
            solarSystemController.getSolarSystemByDate(1L);
        } catch (SolarSystemNotFoundException ex) {
            assertEquals("Solar system not found with date: 1", ex.getMessage());
        }

        verify(solarSystemService, times(1)).getSolarSystemByDate(1L);
    }

    @Test
    public void testGetSolarSystemWithMaxRainFactor() {
        SolarSystem maxRainFactorSolarSystem = new SolarSystem();
        when(solarSystemService.findSolarSystemWithMaxPerimeter()).thenReturn(Optional.of(maxRainFactorSolarSystem));

        ResponseEntity<SolarSystem> response = solarSystemController.getSolarSystemWithMaxPerimeter();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(maxRainFactorSolarSystem, response.getBody());
        verify(solarSystemService, times(1)).findSolarSystemWithMaxPerimeter();
    }

    @Test
    public void testGetSolarSystemWithMaxRainFactor_NotFound() {
        when(solarSystemService.findSolarSystemWithMaxPerimeter()).thenReturn(Optional.empty());

        try {
            solarSystemController.getSolarSystemWithMaxPerimeter();
        } catch (SolarSystemNotFoundException e) {
            assertEquals("Solar system with max perimeter not found", e.getMessage());
        }

        verify(solarSystemService, times(1)).findSolarSystemWithMaxPerimeter();
    }
}
