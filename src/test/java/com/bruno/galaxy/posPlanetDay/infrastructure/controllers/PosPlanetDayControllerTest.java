package com.bruno.galaxy.posPlanetDay.infrastructure.controllers;

import com.bruno.galaxy.posPlanetDay.application.services.PosPlanetDayService;
import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;
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

public class PosPlanetDayControllerTest {

    @Mock
    private PosPlanetDayService posPlanetDayService;

    @InjectMocks
    private PosPlanetDayController posPlanetDayController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(posPlanetDayController).build();
    }

    @Test
    public void testCreatePosPlanetDay() {
        PosPlanetDay posPlanetDay = new PosPlanetDay();
        when(posPlanetDayService.createPosPlanetDay(any(PosPlanetDay.class))).thenReturn(posPlanetDay);

        ResponseEntity<PosPlanetDay> response = posPlanetDayController.createPosPlanetDay(posPlanetDay);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(posPlanetDay, response.getBody());
        verify(posPlanetDayService, times(1)).createPosPlanetDay(posPlanetDay);
    }

    @Test
    public void testGetPosPlanetDayById() {
        PosPlanetDay posPlanetDay = new PosPlanetDay();
        when(posPlanetDayService.getPosPlanetDayById(anyLong())).thenReturn(Optional.of(posPlanetDay));

        ResponseEntity<PosPlanetDay> response = posPlanetDayController.getPosPlanetDayById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(posPlanetDay, response.getBody());
        verify(posPlanetDayService, times(1)).getPosPlanetDayById(1L);
    }

    @Test
    public void testGetPosPlanetDayById_NotFound() {
        when(posPlanetDayService.getPosPlanetDayById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<PosPlanetDay> response = posPlanetDayController.getPosPlanetDayById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(posPlanetDayService, times(1)).getPosPlanetDayById(1L);
    }

    @Test
    public void testGetAllPosPlanetDay() {
        PosPlanetDay posPlanetDay1 = new PosPlanetDay();
        PosPlanetDay posPlanetDay2 = new PosPlanetDay();
        List<PosPlanetDay> posPlanetDays = Arrays.asList(posPlanetDay1, posPlanetDay2);
        when(posPlanetDayService.getAllPosPlanetDay()).thenReturn(posPlanetDays);

        ResponseEntity<List<PosPlanetDay>> response = posPlanetDayController.getAllPosPlanetDay();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(posPlanetDays, response.getBody());
        verify(posPlanetDayService, times(1)).getAllPosPlanetDay();
    }

    @Test
    public void testUpdatePosPlanetDay() {
        PosPlanetDay posPlanetDay = new PosPlanetDay();
        when(posPlanetDayService.updatePosPlanetDay(anyLong(), any(PosPlanetDay.class))).thenReturn(Optional.of(posPlanetDay));

        ResponseEntity<PosPlanetDay> response = posPlanetDayController.updatePosPlanetDay(1L, posPlanetDay);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(posPlanetDay, response.getBody());
        verify(posPlanetDayService, times(1)).updatePosPlanetDay(1L, posPlanetDay);
    }

    @Test
    public void testUpdatePosPlanetDay_NotFound() {
        when(posPlanetDayService.updatePosPlanetDay(anyLong(), any(PosPlanetDay.class))).thenReturn(Optional.empty());

        PosPlanetDay posPlanetDay = new PosPlanetDay();
        ResponseEntity<PosPlanetDay> response = posPlanetDayController.updatePosPlanetDay(1L, posPlanetDay);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(posPlanetDayService, times(1)).updatePosPlanetDay(1L, posPlanetDay);
    }

    @Test
    public void testDeletePosPlanetDayById() {
        when(posPlanetDayService.deletePosPlanetDay(anyLong())).thenReturn(true);

        ResponseEntity<Void> response = posPlanetDayController.deletePosPlanetDayById(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(posPlanetDayService, times(1)).deletePosPlanetDay(1L);
    }

    @Test
    public void testDeletePosPlanetDayById_NotFound() {
        when(posPlanetDayService.deletePosPlanetDay(anyLong())).thenReturn(false);

        ResponseEntity<Void> response = posPlanetDayController.deletePosPlanetDayById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(posPlanetDayService, times(1)).deletePosPlanetDay(1L);
    }

    @Test
    public void testGetAllPosPlanetDayByPlanetId() {
        PosPlanetDay posPlanetDay1 = new PosPlanetDay();
        PosPlanetDay posPlanetDay2 = new PosPlanetDay();
        List<PosPlanetDay> posPlanetDays = Arrays.asList(posPlanetDay1, posPlanetDay2);
        when(posPlanetDayService.getAllPosPlanetDayByPlanetId(anyLong())).thenReturn(posPlanetDays);

        ResponseEntity<List<PosPlanetDay>> response = posPlanetDayController.getAllPosPlanetDayByPlanetId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(posPlanetDays, response.getBody());
        verify(posPlanetDayService, times(1)).getAllPosPlanetDayByPlanetId(1L);
    }
}
