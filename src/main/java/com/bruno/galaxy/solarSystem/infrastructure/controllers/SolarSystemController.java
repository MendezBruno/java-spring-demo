package com.bruno.galaxy.solarSystem.infrastructure.controllers;

import com.bruno.galaxy.solarSystem.application.services.SolarSystemService;
import com.bruno.galaxy.solarSystem.domain.model.SolarSystem;
import com.bruno.galaxy.solarSystem.infrastructure.exception.SolarSystemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solarSystem")
public class SolarSystemController {

    private final SolarSystemService solarSystemService;

    public SolarSystemController(SolarSystemService solarSystemService) {
        this.solarSystemService = solarSystemService;
    }


    @PostMapping
    public ResponseEntity<SolarSystem> createSolarSystem(@RequestBody SolarSystem solarSystem) {
        SolarSystem createdSolarSystem = solarSystemService.createSolarSystem(solarSystem);
        return new ResponseEntity<>(createdSolarSystem, HttpStatus.CREATED);
    }

    @GetMapping("/{solarSystemId}")
    public ResponseEntity<SolarSystem> getSolarSystemById(@PathVariable Long solarSystemId) {
        SolarSystem solarSystem = solarSystemService.getSolarSystemById(solarSystemId)
                .orElseThrow(() -> new SolarSystemNotFoundException("Solar system not found with id: " + solarSystemId));
        return new ResponseEntity<>(solarSystem, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SolarSystem>> getAllSolarSystem() {
        List<SolarSystem> solarSystem = solarSystemService.getAllSolarSystem();
        return new ResponseEntity<>(solarSystem, HttpStatus.OK);
    }

    @PutMapping("/{solarSystemId}")
    public ResponseEntity<SolarSystem> updateSolarSystem(@PathVariable Long solarSystemId, @RequestBody SolarSystem updatedSolarSystem) {
        SolarSystem solarSystem = solarSystemService.updateSolarSystem(solarSystemId, updatedSolarSystem)
                .orElseThrow(() -> new SolarSystemNotFoundException("Solar system not found with id: " + solarSystemId));
        return new ResponseEntity<>(solarSystem, HttpStatus.OK);
    }

    @DeleteMapping("/{solarSystemId}")
    public ResponseEntity<Void> deleteSolarSystemById(@PathVariable Long solarSystemId) {
        if (solarSystemService.deleteSolarSystem(solarSystemId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new SolarSystemNotFoundException("Solar system not found with id: " + solarSystemId);
        }
    }

    @GetMapping("/date/{solarDate}")
    public ResponseEntity<SolarSystem> getSolarSystemByDate(@PathVariable Long solarDate) {
        SolarSystem solarSystem = solarSystemService.getSolarSystemByDate(solarDate)
                .orElseThrow(() -> new SolarSystemNotFoundException("Solar system not found with date: " + solarDate));
        return new ResponseEntity<>(solarSystem, HttpStatus.OK);
    }

    @GetMapping("/max-perimeter")
    public ResponseEntity<SolarSystem> getSolarSystemWithMaxPerimeter() {
        SolarSystem solarSystem = solarSystemService.findSolarSystemWithMaxPerimeter()
                .orElseThrow(() -> new SolarSystemNotFoundException("Solar system with max perimeter not found"));
        return new ResponseEntity<>(solarSystem, HttpStatus.OK);
    }

    @GetMapping("/drought-days")
    public ResponseEntity<List<Long>> getDroughtPeriods() {
        List<Long> droughtDays = solarSystemService.getAllDroughtDays();
        return new ResponseEntity<>(droughtDays, HttpStatus.OK);
    }

    @GetMapping("/rainy-days")
    public ResponseEntity<List<Long>> getRainyPeriods() {
        List<Long> rainyDays = solarSystemService.getAllRainyDays();
        return new ResponseEntity<>(rainyDays, HttpStatus.OK);
    }
}
