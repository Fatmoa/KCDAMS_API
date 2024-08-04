package com.kcdams.demo.Controller;


import com.kcdams.demo.Models.Nursing;
import com.kcdams.demo.Services.NursingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nurs")
@CrossOrigin

public class NursingController {
    @Autowired
    private NursingServices nursingService;

    @GetMapping("/all")
    public List<Nursing> getAllNursing() {
        return nursingService.getAllNursing();
    }

    @GetMapping("/{NusId}")
    public ResponseEntity<Nursing> getNursingByCode(@PathVariable int NusId) {
        Nursing nursing = nursingService.getNursingByCode(NusId);
        return nursing != null ? new ResponseEntity<>(nursing, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editNursing/{id}")
    public Optional<Nursing> updateNursing(@PathVariable("id") int id, @RequestBody Nursing nursing) {
        return nursingService.updateNursing(id, nursing);
    }

    @PostMapping("/save")
    public ResponseEntity<Nursing> createNursing(@RequestBody Nursing nursing) {
        Nursing savedNursing = nursingService.saveNursing(nursing);
        return new ResponseEntity<>(savedNursing, HttpStatus.CREATED);
    }

    @DeleteMapping("/{NusId}")
    public ResponseEntity<Void> deleteNursing(@PathVariable int NusId) {
        nursingService.deleteNursing(NusId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
