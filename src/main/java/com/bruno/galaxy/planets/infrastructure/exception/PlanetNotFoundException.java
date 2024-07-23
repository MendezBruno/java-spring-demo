package com.bruno.galaxy.planets.infrastructure.exception;

public class PlanetNotFoundException extends RuntimeException {
    public PlanetNotFoundException(String message) {
        super(message);
    }
}
