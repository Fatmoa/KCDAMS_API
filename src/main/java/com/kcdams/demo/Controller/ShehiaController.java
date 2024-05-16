package com.kcdams.demo.Controller;


import com.kcdams.demo.Models.Shehia;
import com.kcdams.demo.Services.ShehiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/shehia")
@CrossOrigin

public class ShehiaController {
    @Autowired
    private ShehiaService shehiaService;
    @GetMapping("/all")
    public List<Shehia> getAllShehia() {
        return shehiaService.getAllShehia();
    }

    @GetMapping("/allShehiaByDistrictStatusOne/{district_code}")
    public List<Shehia> allShehiaByDistrictStatusOne(@PathVariable int district_code) {
        return shehiaService.allShehiaByDistrictStatusOne(district_code);
    }

    @GetMapping("/{shehiaCode}")
    public ResponseEntity<Shehia> getShehiaByCode(@PathVariable int shehiaCode) {
        Shehia shehia = shehiaService.getShehiaByCode(shehiaCode);
        return shehia != null ? new ResponseEntity<>(shehia, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("save")
    public ResponseEntity<Shehia> createShehia(@RequestBody Shehia shehia) {
        Shehia savedShehia = shehiaService.saveShehia(shehia);
        return new ResponseEntity<>(savedShehia, HttpStatus.CREATED);
    }

    @PutMapping("/editShehia/{id}")
    public Optional<Shehia> updateShehia(@PathVariable int id, @RequestBody Shehia shehia) {
        return shehiaService.updateShehia(id, shehia);
    }

    @DeleteMapping("/{shehiaCode}")
    public ResponseEntity<Void> deleteShehia(@PathVariable int shehiaCode) {
        shehiaService.deleteShehia(shehiaCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}