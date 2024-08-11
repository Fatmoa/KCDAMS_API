package com.kcdams.demo.Services;

import com.kcdams.demo.Models.Doctor;
import com.kcdams.demo.Repository.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorByCode(int drId) {return doctorRepository.findById(drId).orElse(null);}

    @Transactional
    public Optional<Doctor> updateDoctor(int drId, Doctor doctor) {
        return doctorRepository.findById(drId).map(z -> {
            z.setDrName(doctor.getDrName());
            z.setDrMname(doctor.getDrMname());
            z.setDrLname(doctor.getDrLname());
            z.setDrGender(doctor.getDrGender());
            z.setDrEmail(doctor.getDrEmail());
            z.setDrNumb(doctor.getDrNumb());
            z.setDrEmplNum(doctor.getDrEmplNum());
            return z;
        });
    }

    public Doctor saveDoctor(Doctor doctor) {
        Optional<Doctor> z = doctorRepository.checkExistingDoctor(doctor.getDrId());
        if (z.isEmpty()) {
            return doctorRepository.save(doctor);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Doctor already exists");
        }
    }

    public void deleteDoctor(int drId) {
        doctorRepository.deleteById(drId);
    }

}
