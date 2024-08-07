package com.kcdams.demo.Controller;


import com.kcdams.demo.Models.Observation;
import com.kcdams.demo.Services.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/obs")
@CrossOrigin

public class ObservationController {
    @Autowired
    private ObservationService observationService;

    @GetMapping("/all")
    public List<Observation> getAllObservation(){
        return observationService.getAllObservation();
    }

    @GetMapping("/{obId}")
    public ResponseEntity<Observation> getObservationByCode(@PathVariable int obId) {
        Observation observation = observationService.getObservationByCode(obId);
        return observation != null ? new ResponseEntity<>(observation, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editObservation/{id}")
    public Optional<Observation> updateObservation(@PathVariable("id") int id, @RequestBody Observation observation) {
        return observationService.updateObservation(id, observation);
    }

    @PostMapping("/save")
    public ResponseEntity<Observation> createObservation(@RequestBody Observation observation) {
        Observation savedObservation = observationService.saveObservation(observation);
        return new ResponseEntity<>(savedObservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{obId}")
    public ResponseEntity<Void> deleteObservation(@PathVariable int obId) {
        observationService.deleteObservation(obId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
