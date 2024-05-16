package com.kcdams.demo.Services;

import com.kcdams.demo.Models.Region;
import com.kcdams.demo.Repository.RegionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Region getRegionByCode(int regionCode) {
        return regionRepository.findById(regionCode).orElse(null);
    }

    @Transactional
    public Optional<Region> updateRegion(int regionCode, Region region) {
        return regionRepository.findById(regionCode).map(r -> {
            r.setRegionCode(region.getRegionCode());
            r.setRegionName(region.getRegionName());
            r.setRegionStatus(1);
            r.setZone(region.getZone());
            return r;
        });
    }

    public Region saveRegion(Region region) {
        Optional<Region> check = regionRepository.findById(region.getRegionCode());
        if (check.isPresent()) {
            return new Region();
        } else {
            Region r = new Region();
            r.setRegionCode(region.getRegionCode());
            r.setRegionName(region.getRegionName());
            r.setRegionStatus(1);
            r.setZone(region.getZone());
            return regionRepository.save(r);
        }
    }

    public void deleteRegion(int regionCode) {
        regionRepository.deleteById(regionCode);
    }

    public List<Region> allRegionsByZoneCode(int zone_code) {
        List<Region> regions = regionRepository.allRegionsByZoneCode(zone_code);
        if (regions.size() > 0) {
            return regions;
        } else {
            return new ArrayList<>();
        }
    }

    public List<Region> allRegionsByZoneCodeStatusOne(int zone_code) {
        List<Region> regions = regionRepository.allRegionsByZoneCodeStatusOne(zone_code);
        if (regions.size() > 0) {
            return regions;
        } else {
            return new ArrayList<>();
        }
    }
}


