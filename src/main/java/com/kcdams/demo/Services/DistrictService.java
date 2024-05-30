package com.kcdams.demo.Services;

import com.kcdams.demo.Models.District;
import com.kcdams.demo.Repository.DistrictRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    public List<District> allDistrictByRegionStatusOne(int region_code) {
        return districtRepository.allDistrictByRegionStatusOne(region_code);
    }

    public District getDistrictByCode(int districtCode) {
        return districtRepository.findById(districtCode).orElse(null);
    }

    public District saveDistrict(District district) {
        Optional<District> d = districtRepository.checkExistingDistrict(district.getDistrictCode());
        if (d.isPresent()) {
            throw new ResponseStatusException(HttpStatus.FOUND, "Exist district");
        } else {
            return districtRepository.save(district);
        }
    }

    public void deleteDistrict(int districtCode) {
        districtRepository.deleteById(districtCode);
    }

    @Transactional
    public Optional<District> updateDistrict(int id, District district) {
        return districtRepository.findById(id).map(d -> {
            d.setDistrictCode(district.getDistrictCode());
            d.setDistrictName(district.getDistrictName());
            d.setDistrictStatus(1);
            d.setRegion(district.getRegion());
            return d;
        });
    }

    public List<District> allDistrictByRegionCode(int region_code) {
        List<District> districts = districtRepository.allDistrictByRegionStatusOne(region_code);
        if (districts.size()>0){
            return districts;
        }
        else {
            return new ArrayList<>();
        }
    }
}
