package com.kcdams.demo.Controller;

import com.kcdams.demo.Models.Psychologist;
import com.kcdams.demo.Services.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/psychologist")
@CrossOrigin

public class PsychologistController {
    @Autowired
    private PsychologistService psychologistService;

    @GetMapping("/all")
    public List<Psychologist> getAllPsychologist() {
        return psychologistService.getAllPsychologist();
    }

    @GetMapping("/{pyId}")
    public ResponseEntity<Psychologist> getPsychologistByCode(@PathVariable int pyId) {
        Psychologist psychologist = psychologistService.getPsychologistByCode(pyId);
        return psychologist != null ? new ResponseEntity<>(psychologist, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editPsychologist/{id}")
    public Optional<Psychologist> updatePsychologist(@PathVariable("id") int id, @RequestBody Psychologist psychologist) {
        return psychologistService.updatePsychologist(id, psychologist);
    }

    @PostMapping("/save")
    public ResponseEntity<Psychologist> createPsychologist(@RequestBody Psychologist psychologist) {
        Psychologist savedPsychologist = psychologistService.savePsychologist(psychologist);
        return new ResponseEntity<>(savedPsychologist, HttpStatus.CREATED);
    }

    @DeleteMapping("/{pyId}")
    public ResponseEntity<Void> deletePsychologist(@PathVariable int pyId) {
        psychologistService.deletePsychologist(pyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
