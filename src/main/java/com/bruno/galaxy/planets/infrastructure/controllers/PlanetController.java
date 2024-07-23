package com.bruno.galaxy.planets.infrastructure.controllers;

import com.bruno.galaxy.planets.application.services.PlanetService;
import com.bruno.galaxy.planets.domain.model.Planet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planets")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping
    public ResponseEntity<Planet> createPlanet(@RequestBody Planet planet) {
        Planet createdPlanet = planetService.createPlanet(planet);
        return new ResponseEntity<>(createdPlanet, HttpStatus.CREATED);
    }

    @GetMapping("/{planetId}")
    public ResponseEntity<Planet> getPlanetById(@PathVariable Long planetId) {
        return planetService.getPlanetById(planetId)
                .map(planet -> new ResponseEntity<>(planet, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Planet>> getAllPlanets() {
        List<Planet> planets = planetService.getAllPlanets();
        return new ResponseEntity<>(planets, HttpStatus.OK);
    }

    @PutMapping("/{planetId}")
    public ResponseEntity<Planet> updatePlanet(@PathVariable Long planetId, @RequestBody Planet updatedPlanet) {
        return planetService.updatePlanet(planetId, updatedPlanet)
                .map(planet -> new ResponseEntity<>(planet, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{planetId}")
    public ResponseEntity<Void> deletePlanetById(@PathVariable Long planetId) {
        if (planetService.deletePlanet(planetId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
