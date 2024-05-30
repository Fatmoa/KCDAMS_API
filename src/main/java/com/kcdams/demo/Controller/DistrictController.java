package com.kcdams.demo.Controller;

import com.kcdams.demo.Models.District;
import com.kcdams.demo.Models.Region;
import com.kcdams.demo.Services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/districts")
@CrossOrigin

public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @GetMapping("/all")
    public List<District> getAllDistricts() {
        return districtService.getAllDistricts();
    }

    @GetMapping("/allDistrictByRegionStatusOne/{region_code}")
    public List<District> allDistrictByRegionStatusOne(@PathVariable int region_code) {
        return districtService.allDistrictByRegionStatusOne(region_code);
    }

    @GetMapping("/{districtCode}")
    public ResponseEntity<District> getDistrictByCode(@PathVariable int districtCode) {
        District district = districtService.getDistrictByCode(districtCode);
        return district != null ? new ResponseEntity<>(district, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<District> createDistrict(@RequestBody District district) {
        District savedDistrict = districtService.saveDistrict(district);
        return new ResponseEntity<>(savedDistrict, HttpStatus.CREATED);
    }

    @PutMapping("/editDistrict/{id}")
    public Optional<District> updateDistrict(@PathVariable int id, @RequestBody District district) {
        return districtService.updateDistrict(id, district);
    }

    @DeleteMapping("/{districtCode}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable int districtCode) {
        districtService.deleteDistrict(districtCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byRegionCode/{regionCode}")
    public List<District> allDistrictByRegionCode(@PathVariable int regionCode) {
        return districtService.allDistrictByRegionCode(regionCode);
    }
}
