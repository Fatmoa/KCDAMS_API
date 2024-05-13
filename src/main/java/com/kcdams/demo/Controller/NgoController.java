package com.kcdams.demo.Controller;

import com.kcdams.demo.Models.Ngo;
import com.kcdams.demo.Models.Region;
import com.kcdams.demo.Models.Zone;
import com.kcdams.demo.Services.NgoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ngos")
@CrossOrigin

public class NgoController {
    @Autowired
    public NgoService ngoService;
    @GetMapping("/all")
    public List<Ngo> getAllRegion(){
        return ngoService.getAllRegions();
    }
    @GetMapping("ngoStatusOne")
    public List<Ngo>  ngoStatusOne(){
        return ngoService.ngoStatusOne();
    }

    @GetMapping("/{ngoCode}")
    public ResponseEntity<Ngo> getNgoByCode(@PathVariable int ngoCode){
        Ngo ngo = ngoService.getNgoByCode(ngoCode);
        return ngo != null ? new ResponseEntity<>(ngo, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editNgo/{id}")
    public Optional<Ngo> updateZone(@PathVariable("id") int id, @RequestBody Ngo ngo) {
        return ngoService.updateNgo(id, ngo);
    }

    @PostMapping("/save")
    public ResponseEntity<Ngo> createNgo(@RequestBody Ngo ngo) {
        Ngo savedNgo = ngoService.saveNgo(ngo);
        return new ResponseEntity<>(savedNgo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{ngoCode}")
    public ResponseEntity<Void> deleteNgo(@PathVariable int ngoCode) {
        ngoService.deleteNgo(ngoCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
