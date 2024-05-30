package com.kcdams.demo.Controller;

import com.kcdams.demo.Models.Reception;
import com.kcdams.demo.Services.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/reception")
@CrossOrigin


public class ReceptionController {
    @Autowired
    public ReceptionService receptionService;

    @GetMapping("/all")
    public List<Reception> getAllReception(){
        return receptionService.getAllReception();
    }

    @GetMapping("/{matCode}")
    public ResponseEntity<Reception> getReceptionByCode(@PathVariable int matCode){
        Reception reception = receptionService.getReceptionByCode(matCode);
        return reception != null ? new ResponseEntity<>(reception, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Reception> createReception(@RequestBody Reception reception) {
        Reception savedReception = receptionService.saveReception(reception);
        return new ResponseEntity<>(savedReception, HttpStatus.CREATED);
    }

    @PutMapping("/editReception/{id}")
    public Optional<Reception> updateReception(@PathVariable("id") int id, @RequestBody Reception reception) {
        return receptionService.updateReception(id, reception);
    }

    @DeleteMapping("/{matCode}")
    public ResponseEntity<Void> deleteReception(@PathVariable int matCode) {
        receptionService.deleteReception(matCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
