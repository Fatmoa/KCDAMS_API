package com.kcdams.demo.Services;

import com.kcdams.demo.Models.Drugs;
import com.kcdams.demo.Repository.DrugsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class DrugsService {
    @Autowired
    public DrugsRepository drugsRepository;

    public List<Drugs> getAllDrugs() {
        return drugsRepository .findAll();
    }

    public Drugs getDrugByCode(int drugCode) {
        return drugsRepository.findById(drugCode).orElse(null);
    }

    @Transactional
    public Optional<Drugs> updateDrugs(int drugCode, Drugs drugs) {
        return drugsRepository.findById(drugCode).map(z -> {
            z.setDrugName(drugs.getDrugName());
            return z;
        });
    }

    public Drugs saveDrugs(Drugs drugs) {
        Optional<Drugs> z = drugsRepository.checkExistingDrugs(drugs.getDrugCode());
        if (z.isEmpty()) {
            return drugsRepository.save(drugs);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Drug already exists");
        }
    }

    public void deleteDrug(int drugCode) {
        drugsRepository.deleteById(drugCode);
    }
}

