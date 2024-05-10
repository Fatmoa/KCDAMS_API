package com.kcdams.demo.Controller;

import com.kcdams.demo.Models.Region;
import com.kcdams.demo.Services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/regions")
@CrossOrigin

public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("/all")
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }

    @GetMapping("/{regionCode}")
    public ResponseEntity<Region> getRegionByCode(@PathVariable int regionCode) {
        Region region = regionService.getRegionByCode(regionCode);
        return region != null ? new ResponseEntity<>(region, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editRegion/{id}")
    public Optional<Region> updateRegion(@PathVariable("id") int id, @RequestBody Region region) {
        return regionService.updateRegion(id, region);
    }

    @PostMapping("/save")
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        Region savedRegion = regionService.saveRegion(region);
        return new ResponseEntity<>(savedRegion, HttpStatus.CREATED);
    }

    @DeleteMapping("/{regionCode}")
    public ResponseEntity<Void> deleteRegion(@PathVariable int regionCode) {
        regionService.deleteRegion(regionCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byZoneCode/{zoneCode}")
    public List<Region> allRegionsByZoneCode(@PathVariable int zoneCode) {
        return regionService.allRegionsByZoneCode(zoneCode);
    }

    @GetMapping("/allRegionsByZoneCodeStatusOne/{zoneCode}")
    public List<Region> allRegionsByZoneCodeStatusOne(@PathVariable int zoneCode) {
        return regionService.allRegionsByZoneCodeStatusOne(zoneCode);
    }
}

