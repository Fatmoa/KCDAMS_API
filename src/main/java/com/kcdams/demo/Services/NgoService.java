package com.kcdams.demo.Services;

import com.kcdams.demo.Models.Ngo;
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

    public List<Ngo> getAllNgo(){return ngoRepository.findAll();}
    public List<Ngo> ngoStatusOne() {
        return ngoRepository.ngoStatusOne();
    }

    public Ngo getNgoByCode(int ngoCode) {
        return ngoRepository.findById(ngoCode).orElse(null);
    }

    @Transactional
    public Optional<Ngo> updateNgo(int ngoCode, Ngo ngo) {
        return ngoRepository.findById(ngoCode).map(n -> {
            n.setNgoName(ngo.getNgoName());
            n.setNgoStatus(1);
            return n;
        });
    }

        public Ngo saveNgo(Ngo ngo) {
            Optional<Ngo> n = ngoRepository.checkExistingNgo(ngo.getNgoCode());
            if (n.isEmpty()) {
                return ngoRepository.save(ngo);
            } else {
                throw new ResponseStatusException(HttpStatus.FOUND, "Ngo already exists");
            }
        }
    public void deleteNgo(int ngoCode) {
        ngoRepository.deleteById(ngoCode);
    }
    }

