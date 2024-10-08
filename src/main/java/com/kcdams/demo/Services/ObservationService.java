package com.kcdams.demo.Services;


import com.kcdams.demo.Models.Observation;
import com.kcdams.demo.Repository.ObservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class ObservationService {
    @Autowired
    private ObservationRepository observationRepository;

    public List<Observation> getAllObservation() {
        return observationRepository.findAll();
    }

    public Observation getObservationByCode(int obId) {
        return observationRepository.findById(obId).orElse(null);
    }

    public Observation saveObservation(Observation observation) {
        Optional<Observation> z = observationRepository.checkExistingObservation(observation.getObId());
        if (z.isEmpty()) {
            return observationRepository.save(observation);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Already exists");
        }
    }

    public void deleteObservation(int obId) {
        observationRepository.deleteById(obId);
    }

    @Transactional
    public Optional<Observation> updateObservation(int obId, Observation observation) {
        return observationRepository.findById(obId).map(z -> {
            z.setDeseas(observation.getDeseas());
            z.setDrugType(observation.getDrugType());
            z.setComment(observation.getComment());
            z.setBp(observation.getBp());
            z.setNiddle(observation.getNiddle());
            z.setPhlebitis(observation.getPhlebitis());
            z.setVenous(observation.getVenous());
            z.setPl_niddle(observation.getPl_niddle());
            z.setPl_phlebitis(observation.getPl_phlebitis());
            z.setPl_venous(observation.getPl_venous());
            z.setLastUsg(observation.getLastUsg());
            z.setUsag(observation.getUsag());
            z.setLastDrug(observation.getLastDrug());
            z.setTBtreat(observation.getTBtreat());
            z.setPress(observation.getPress());
            z.setWeight(observation.getWeight());
            z.setHeight(observation.getHeight());
            z.setPulse(observation.getPulse());
            z.setPr(observation.getPr());
            z.setPartner(observation.getPartner());
            return z;
        });
    }


}
