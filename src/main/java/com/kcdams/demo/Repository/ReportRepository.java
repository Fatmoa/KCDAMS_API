package com.kcdams.demo.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin
public class ReportRepository {

    @Autowired
    public  ReceptionRepository receptionRepository;
    public RegistrarRepository registrarRepository;
    public PsychologyRepository psychologyRepository;
    public NursingRepository nursingRepository;
    public DoctorRepository doctorRepository;

    public List<Map<String,Object>> patientDistrictReport(){
        return receptionRepository.patientDistrictReport();
    }

    public List<Map<String,Object>> patientDateReport(){
        return receptionRepository.patientDateReport();
    }

    public List<Map<String,Object>> patientGenderReport(){
        return receptionRepository.patientGenderReport();
    }

    public List<Map<String,Object>> doctorGenderReport(){
        return doctorRepository.doctorGenderReport();
    }


    public long getAllRegistrar(){
        return registrarRepository.count();
    }

    public long getAllPsychology(){
        return psychologyRepository.count();
    }

    public long getAllNursing(){
        return nursingRepository.count();
    }

    public long getAllDoctor(){
        return doctorRepository.count();
    }
}
