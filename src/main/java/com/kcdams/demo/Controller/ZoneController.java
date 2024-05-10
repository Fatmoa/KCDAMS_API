package com.kcdams.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kcdams.demo.Services.ZoneService;
import com.kcdams.demo.Models.Zone;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/zones")
@CrossOrigin

public class ZoneController {
    @Autowired
    private ZoneService zoneService;

    @GetMapping("/all")
    public List<Zone> getAllZones() {
        return zoneService.getAllZones();
    }
    @GetMapping("/zoneStatusOne")
    public List<Zone> zoneStatusOne() {
        return zoneService.zoneStatusOne();
    }

    @GetMapping("/{zoneCode}")
    public ResponseEntity<Zone> getZoneByCode(@PathVariable int zoneCode) {
        Zone zone = zoneService.getZoneByCode(zoneCode);
        return zone != null ? new ResponseEntity<>(zone, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editZone/{id}")
    public Optional<Zone> updateZone(@PathVariable("id") int id, @RequestBody Zone zone) {
        return zoneService.updateZone(id, zone);
    }

    @PostMapping("/save")
    public ResponseEntity<Zone> createZone(@RequestBody Zone zone) {
        Zone savedZone = zoneService.saveZone(zone);
        return new ResponseEntity<>(savedZone, HttpStatus.CREATED);
    }

    @DeleteMapping("/{zoneCode}")
    public ResponseEntity<Void> deleteZone(@PathVariable int zoneCode) {
        zoneService.deleteZone(zoneCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
