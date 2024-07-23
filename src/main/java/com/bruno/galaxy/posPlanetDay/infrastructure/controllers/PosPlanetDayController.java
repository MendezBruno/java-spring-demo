package com.bruno.galaxy.posPlanetDay.infrastructure.controllers;

import com.bruno.galaxy.posPlanetDay.application.services.PosPlanetDayService;
import com.bruno.galaxy.posPlanetDay.domain.model.PosPlanetDay;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posPlanetDay")
public class PosPlanetDayController {

    private final PosPlanetDayService posPlanetDayService;

    public PosPlanetDayController(PosPlanetDayService posPlanetDayService) {
        this.posPlanetDayService = posPlanetDayService;
    }

    @PostMapping
    public ResponseEntity<PosPlanetDay> createPosPlanetDay(@RequestBody PosPlanetDay posPlanetDay) {
        PosPlanetDay createdPosPlanetDay = posPlanetDayService.createPosPlanetDay(posPlanetDay);
        return new ResponseEntity<>(createdPosPlanetDay, HttpStatus.CREATED);
    }

    @GetMapping("/{posPlanetDayId}")
    public ResponseEntity<PosPlanetDay> getPosPlanetDayById(@PathVariable Long posPlanetDayId) {
        return posPlanetDayService.getPosPlanetDayById(posPlanetDayId)
                .map(posPlanetDay -> new ResponseEntity<>(posPlanetDay, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<PosPlanetDay>> getAllPosPlanetDay() {
        List<PosPlanetDay> posPlanetDay = posPlanetDayService.getAllPosPlanetDay();
        return new ResponseEntity<>(posPlanetDay, HttpStatus.OK);
    }

    @PutMapping("/{posPlanetDayId}")
    public ResponseEntity<PosPlanetDay> updatePosPlanetDay(@PathVariable Long posPlanetDayId, @RequestBody PosPlanetDay updatedPosPlanetDay) {
        return posPlanetDayService.updatePosPlanetDay(posPlanetDayId, updatedPosPlanetDay)
                .map(posPlanetDay -> new ResponseEntity<>(posPlanetDay, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{posPlanetDayId}")
    public ResponseEntity<Void> deletePosPlanetDayById(@PathVariable Long posPlanetDayId) {
        if (posPlanetDayService.deletePosPlanetDay(posPlanetDayId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/planet/{planetId}")
    public ResponseEntity<List<PosPlanetDay>> getAllPosPlanetDayByPlanetId(@PathVariable Long planetId) {
        List<PosPlanetDay> posPlanetDay = posPlanetDayService.getAllPosPlanetDayByPlanetId(planetId);
        return new ResponseEntity<>(posPlanetDay, HttpStatus.OK);
    }

}
