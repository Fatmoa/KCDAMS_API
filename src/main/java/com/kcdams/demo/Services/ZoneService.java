package com.kcdams.demo.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kcdams.demo.Repository.ZoneRepository;
import com.kcdams.demo.Models.Zone;

import jakarta.transaction.Transactional;

@Service
public class ZoneService {
    @Autowired
    private ZoneRepository zoneRepository;

    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    public List<Zone> zoneStatusOne() {
        return zoneRepository.zoneStatusOne();
    }

    public Zone getZoneByCode(int zoneCode) {
        return zoneRepository.findById(zoneCode).orElse(null);
    }

    @Transactional
    public Optional<Zone> updateZone(int zoneCode, Zone zone) {
        return zoneRepository.findById(zoneCode).map(z -> {
            z.setZoneName(zone.getZoneName());
            z.setZoneStatus(1);
            return z;
        });
    }

    public Zone saveZone(Zone zone) {
        Optional<Zone> z = zoneRepository.checkExistingZone(zone.getZoneCode());
        if (z.isEmpty()) {
            return zoneRepository.save(zone);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Zone already exists");
        }
    }

    public void deleteZone(int zoneCode) {
        zoneRepository.deleteById(zoneCode);
    }
}
