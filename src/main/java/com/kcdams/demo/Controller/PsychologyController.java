package com.kcdams.demo.Controller;

import com.kcdams.demo.Models.Psychology;
import com.kcdams.demo.Services.PsychologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/psychol")
@CrossOrigin

public class PsychologyController {
    @Autowired
    private PsychologyService psychologyService;

    @GetMapping("/all")
    public List<Psychology> getAllPsychology() {
        return psychologyService.getAllPsychology();
    }

    @GetMapping("/{psyId}")
    public ResponseEntity<Psychology> getPsychologyByCode(@PathVariable int psyId) {
        Psychology psychology = psychologyService.getPsychologyByCode(psyId);
        return psychology != null ? new ResponseEntity<>(psychology, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editPsychology/{id}")
    public Optional<Psychology> updatePsychology(@PathVariable("id") int id, @RequestBody Psychology psychology) {
        return psychologyService.updatePsychology(id, psychology);
    }

    @PostMapping("/save")
    public ResponseEntity<Psychology> createPsychology(@RequestBody Psychology psychology) {
        Psychology savedPsychology = psychologyService.savePsychology(psychology);
        return new ResponseEntity<>(savedPsychology, HttpStatus.CREATED);
    }

    @DeleteMapping("/{psyId}")
    public ResponseEntity<Void> deletePsychology(@PathVariable int psyId) {
        psychologyService.deletePsychology(psyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
