package com.bruno.galaxy.period.infrastructure.exception;

public class PeriodNotFoundException extends RuntimeException {
    public PeriodNotFoundException(String message) {
        super(message);
    }
}
