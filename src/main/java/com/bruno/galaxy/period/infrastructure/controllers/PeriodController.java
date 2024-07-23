package com.bruno.galaxy.period.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bruno.galaxy.period.application.services.PeriodService;
import com.bruno.galaxy.period.domain.model.Period;

import java.util.List;

@RestController
@RequestMapping("/api/periods")
public class PeriodController {

    private final PeriodService periodService;

    public PeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    @PostMapping
    public ResponseEntity<Period> createPeriod(@RequestBody Period period) {
        Period createdPeriod = periodService.createPeriod(period);
        return new ResponseEntity<>(createdPeriod, HttpStatus.CREATED);
    }

    @GetMapping("/{periodId}")
    public ResponseEntity<Period> getPeriodById(@PathVariable Long periodId) {
        return periodService.getPeriodById(periodId)
                .map(period -> new ResponseEntity<>(period, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Period>> getAllPeriods() {
        List<Period> periods = periodService.getAllPeriods();
        return new ResponseEntity<>(periods, HttpStatus.OK);
    }

    @PutMapping("/{periodId}")
    public ResponseEntity<Period> updatePeriod(@PathVariable Long periodId, @RequestBody Period updatedPeriod) {
        return periodService.updatePeriod(periodId, updatedPeriod)
                .map(period -> new ResponseEntity<>(period, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{periodId}")
    public ResponseEntity<Void> deletePeriodById(@PathVariable Long periodId) {
        if (periodService.deletePeriod(periodId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/wheaterCondition/{wheaterCondition}")
    public ResponseEntity<List<Period>> getPeriodsByWheaterCondition(@PathVariable String wheaterCondition) {
        List<Period> periods = periodService.getPeriodsByWheaterCondition(wheaterCondition);
        return new ResponseEntity<>(periods, HttpStatus.OK);
    }

}
