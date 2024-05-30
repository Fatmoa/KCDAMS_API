package com.kcdams.demo.Controller;

import com.kcdams.demo.Models.Kin;
import com.kcdams.demo.Services.KinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kins")
@CrossOrigin

public class KinController {
    @Autowired
    public KinService kinService;

    @GetMapping("/all")
    public List<Kin> getAllKins() {
        return kinService.getAllKins();
    }

    @GetMapping("/{kinCode}")
    public ResponseEntity<Kin> getDrugByCode(@PathVariable int kinCode) {
        Kin kin = kinService.getKinByCode(kinCode);
        return kin != null ? new ResponseEntity<>(kin, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editKin{id}")
    public Optional<Kin> updateKin(@PathVariable("id") int id, @RequestBody Kin kin) {
        return kinService.updateKin(id, kin);
    }
    @PostMapping("/save")
    public ResponseEntity<Kin> createKin(@RequestBody Kin kin) {
        Kin savedKin = kinService.saveKin(kin);
        return new ResponseEntity<>(savedKin, HttpStatus.CREATED);
    }
    @DeleteMapping("/{kinCode}")
    public ResponseEntity<Void> deleteKin(@PathVariable int kinCode) {
        kinService.deleteKin(kinCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
