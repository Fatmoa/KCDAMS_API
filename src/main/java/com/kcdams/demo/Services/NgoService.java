package com.kcdams.demo.Services;


import com.kcdams.demo.Models.Ngo;
import com.kcdams.demo.Models.Region;
import com.kcdams.demo.Models.Zone;
import com.kcdams.demo.Repository.NgoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class NgoService {
    @Autowired
    private NgoRepository ngoRepository;

    public List<Ngo> getAllRegions(){return ngoRepository.findAll();}
    public List<Ngo> ngoStatusOne() {
        return ngoRepository.ngoStatusOne();
    }

    public Ngo getNgoByCode(int ngoCode) {
        return ngoRepository.findById(ngoCode).orElse(null);
    }

    @Transactional
    public Optional<Ngo> updateNgo(int ngoCode, Ngo ngo) {
        return ngoRepository.findById(ngoCode).map(z -> {
            z.setNgoName(ngo.getNgoName());
            z.setNgoStatus(1);
            return z;
        });
    }

        public Ngo saveNgo(Ngo ngo) {
            Optional<Ngo> z = ngoRepository.checkExistingNgo(ngo.getNgoCode());
            if (z.isEmpty()) {
                return ngoRepository.save(ngo);
            } else {
                throw new ResponseStatusException(HttpStatus.FOUND, "Ngo already exists");
            }
        }
    public void deleteNgo(int ngoCode) {
        ngoRepository.deleteById(ngoCode);
    }
    }

