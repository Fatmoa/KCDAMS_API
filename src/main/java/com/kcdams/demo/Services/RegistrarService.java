package com.kcdams.demo.Services;

import com.kcdams.demo.Models.Registrar;
import com.kcdams.demo.Repository.RegistrarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class RegistrarService {
    @Autowired
    private RegistrarRepository registrarRepository;

    public List<Registrar> getAllRegistrar() {
        return registrarRepository.findAll();
    }

    public Registrar getRegistrarByCode(int regId) {
        return registrarRepository.findById(regId).orElse(null);
    }

    @Transactional
    public Optional<Registrar> updateRegistrar(int regId, Registrar registrar) {
        return registrarRepository.findById(regId).map(z -> {
            z.setRegisName(registrar.getRegisName());
            z.setRegisMname(registrar.getRegisMname());
            z.setRegisLname(registrar.getRegisLname());
            z.setResiGender(registrar.getResiGender());
            z.setRegisEmail(registrar.getRegisEmail());
            z.setRegisNumb(registrar.getRegisNumb());
            z.setEmplNum(registrar.getEmplNum());
            return z;
        });
    }

    public Registrar saveRegistrar(Registrar registrar) {
        Optional<Registrar> z = registrarRepository.checkExistingRegistrar(registrar.getRegId());
        if (z.isEmpty()) {
            return registrarRepository.save(registrar);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Registrar already exists");
        }
    }

    public void deleteRegistrar(int regId) {
        registrarRepository.deleteById(regId);
    }

}

