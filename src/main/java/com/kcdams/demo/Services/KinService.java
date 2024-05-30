package com.kcdams.demo.Services;

import com.kcdams.demo.Models.Kin;
import com.kcdams.demo.Repository.KinRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service

public class KinService {
    @Autowired
    public KinRepository kinRepository;
    public Kin saveKinkin;

    public List<Kin> getAllKins() { return kinRepository.findAll();
    }

    public Kin getKinByCode(int kinCode) {
        return kinRepository.findById(kinCode).orElse(null);
    }

    @Transactional
    public Optional<Kin> updateKin(int kinCode, Kin kin) {
        return kinRepository.findById(kinCode).map(k->{
            k.setFirstName(kin.getFirstName());
            k.setLastName(kin.getLastName());
            k.setRelation(kin.getRelation());
            k.setPhNumber(kin.getPhNumber());
            return k;
        });
    }

    public Kin saveKin(Kin kin) {
        Optional<Kin> k = kinRepository.checkExistingKin(kin.getKinCode());
        if (k.isEmpty()){
            return kinRepository.save(kin);
        }else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Kin exist");
        }
    }

    public void deleteKin(int kinCode) {
        kinRepository.deleteById(kinCode);
    }
}
