package com.kcdams.demo.Controller;


import com.kcdams.demo.Models.Clinic;
import com.kcdams.demo.Services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/clinic")
@CrossOrigin

public class ClinicController {
    @Autowired
    private ClinicService clinicService;

    @GetMapping("all")
    public List<Clinic> getAllPatients() {
        return clinicService.getAllPatients();
    }

    @GetMapping("/{clID}")
    public ResponseEntity<Clinic> getPatienttByCode(@PathVariable int clID) {
        Clinic clinic = clinicService.getPatientByCode(clID);
        return clinic != null ? new ResponseEntity<>(clinic, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Clinic> createPatient(@RequestBody Clinic clinic) {
        Clinic savedPatient = clinicService.savePatient(clinic);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PutMapping("/editPatient/{id}")
    public Optional<Clinic> updatePatient(@PathVariable int id, @RequestBody Clinic clinic) {
        return clinicService.updatePatient(id, clinic);
    }

    @DeleteMapping("/{clID}")
    public ResponseEntity<Void> deletePatient(@PathVariable int clID) {
        clinicService.deletePatient(clID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
