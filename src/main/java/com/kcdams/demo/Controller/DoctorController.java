package com.kcdams.demo.Controller;


import com.kcdams.demo.Models.Doctor;
import com.kcdams.demo.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/doctor")
@CrossOrigin
@RestController

public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAllDoctor() {
        return doctorService.getAllDoctor();
    }

    @GetMapping("/{drId}")
    public ResponseEntity<Doctor> getDoctorByCode(@PathVariable int drId) {
        Doctor doctor = doctorService.getDoctorByCode(drId);
        return doctor != null ? new ResponseEntity<>(doctor, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editDoctor/{id}")
    public Optional<Doctor> updateDoctor(@PathVariable("id") int id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }


    @PostMapping("/save")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{drId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int drId) {
        doctorService.deleteDoctor(drId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
