package com.bruno.galaxy.planets.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {

    @Test
    public void testGetPositionClockwise() {
        Planet planet = new Planet(1L, 1, 500, true);
        Long[] position = planet.getPosition(90);
        assertEquals(0, position[0], 0.1);  // Esperamos x = 0
        assertEquals(500, position[1], 0.1);  // Esperamos y = 500
    }

    @Test
    public void testGetPositionCounterclockwise() {
        Planet planet = new Planet(1L, 1, 500, false);
        Long[] position = planet.getPosition(90);
        assertEquals(0, position[0], 0.1);  // Esperamos x = 0
        assertEquals(-500, position[1], 0.1);  // Esperamos y = -500
    }

    @Test
    public void testGetPositionFullCircle() {
        Planet planet = new Planet(1L, 1, 500, true);
        Long[] position = planet.getPosition(360);
        assertEquals(500, position[0], 0.1);  // Esperamos x = 500
        assertEquals(0, position[1], 0.1);  // Esperamos y = 0
    }

    @Test
    public void testGetPositionBeyondFullCircle() {
        Planet planet = new Planet(1L, 1, 500, true);
        Long[] position = planet.getPosition(450);
        assertEquals(0, position[0], 0.1);  // Esperamos x = 0
        assertEquals(500, position[1], 0.1);  // Esperamos y = 500 (como en 90 grados)
    }

    @Test
    public void testGetPositionNegativeDays() {
        Planet planet = new Planet(1L, 1, 500, true);
        Long[] position = planet.getPosition(-90);
        assertEquals(0, position[0], 0.1);  // Esperamos x = 0
        assertEquals(-500, position[1], 0.1);  // Esperamos y = -500 (como en 270 grados)
    }

    @Test
    public void testGetPositionDifferentVelocity() {
        Planet planet = new Planet(1L, 2, 500, true);
        Long[] position = planet.getPosition(45);
        assertEquals(0, position[0], 0.1);  // Esperamos x = 0
        assertEquals(500, position[1], 0.1);  // Esperamos y = 500 (como en 90 grados con velocidad angular 2)
    }
}