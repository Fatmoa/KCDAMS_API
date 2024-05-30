package com.kcdams.demo.Services;

import com.kcdams.demo.Models.District;
import com.kcdams.demo.Models.Shehia;
import com.kcdams.demo.Repository.ShehiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ShehiaService {
    @Autowired
    private ShehiaRepository shehiaRepository;

    public List<Shehia> getAllShehia() {
        return shehiaRepository.findAll();
    }


    public Shehia getShehiaByCode(int shehiaCode) {
        return shehiaRepository.findById(shehiaCode).orElse(null);
    }

    public Shehia saveShehia(Shehia shehia) {
        Optional<Shehia> d = shehiaRepository.checkExistingShehia(shehia.getShehiaCode());
        if (d.isPresent()) {
            throw new ResponseStatusException(HttpStatus.FOUND, "Shehia exist");
        } else {
            return shehiaRepository.save(shehia);
        }
    }

    public void deleteShehia(int shehiaCode) {
        shehiaRepository.deleteById(shehiaCode);
    }

    public Optional<Shehia> updateShehia(int id, Shehia shehia) {
        return shehiaRepository.findById(id).map(s-> {
            s.setShehiaCode(shehia.getShehiaCode());
            s.setShehiaName(shehia.getShehiaName());
            s.setShehiaStatus(1);
            s.setDistrict(shehia.getDistrict());
            return s;
        });
    }


    public List<Shehia> allShehiaByDistrictCodeStatusOne(int district_code) {
        return shehiaRepository.allShehiaByDistrictStatusOne(district_code);
    }


    public List<Shehia> allShehiaByDistrictCode(int district_code) {
        List<Shehia> shehias = shehiaRepository.allShehiaByDistrictStatusOne(district_code);
        if(shehias.size()>0){
            return shehias;
        }else{
            return new ArrayList<>();
        }
    }
}
