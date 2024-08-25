package com.kcdams.demo.Services;

import com.kcdams.demo.Models.Clinic;
import com.kcdams.demo.Repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;

    public List<Clinic> getAllPatients() {
        return clinicRepository.findAll();
    }


    public Clinic getPatientByCode(int clID) {
        return clinicRepository.findById(clID).orElse(null);
    }

    public Clinic savePatient(Clinic clinic) {
        Optional<Clinic> c = clinicRepository.checkExistingPatient(clinic.getClID());
        if (c.isPresent()) {
            throw new ResponseStatusException(HttpStatus.FOUND, "Exist");
        } else {
            return clinicRepository.save(clinic);
        }
    }

    public Optional<Clinic> updatePatient(int id, Clinic clinic) {
        return clinicRepository.findById(id).map(c -> {
            c.setClID(clinic.getClID());
            c.setStartDate(clinic.getStartDate());
            c.setEndingDate(clinic.getEndingDate());
            c.setVisitDate(clinic.getVisitDate());
            c.setDose(clinic.getDose());
            c.setPatientData(clinic.getPatientData());
            return c;
        });
    }

    public void deletePatient(int clID) {
        clinicRepository.deleteById(clID);
    }
}
