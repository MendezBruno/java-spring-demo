package com.bruno.galaxy.solarSystem.infrastructure.exception;

public class SolarSystemNotFoundException extends RuntimeException {
    public SolarSystemNotFoundException(String message) {
        super(message);
    }
}
