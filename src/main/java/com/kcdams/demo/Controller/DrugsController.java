package com.kcdams.demo.Controller;


import com.kcdams.demo.Models.Drugs;
import com.kcdams.demo.Models.Zone;
import com.kcdams.demo.Services.DrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drugs")
@CrossOrigin

public class DrugsController {
    @Autowired
    private DrugsService drugsService;

    @GetMapping("/all")
    public List<Drugs> getAllDrugs() {
        return drugsService.getAllDrugs();
    }

    @GetMapping("/{drugCode}")
    public ResponseEntity<Drugs> getDrugByCode(@PathVariable int drugCode) {
        Drugs drugs = drugsService.getDrugByCode(drugCode);
        return drugs != null ? new ResponseEntity<>(drugs, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editDrug/{id}")
    public Optional<Drugs> updateDrugs(@PathVariable("id") int id, @RequestBody Drugs drugs) {
        return drugsService.updateDrugs(id, drugs);
    }
    @PostMapping("/save")
    public ResponseEntity<Drugs> createDrugs(@RequestBody Drugs drugs) {
        Drugs savedDrugs = drugsService.saveDrugs(drugs);
        return new ResponseEntity<>(savedDrugs, HttpStatus.CREATED);
    }

    @DeleteMapping("/{drugCode}")
    public ResponseEntity<Void> deleteDrug(@PathVariable int drugCode) {
        drugsService.deleteDrug(drugCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
