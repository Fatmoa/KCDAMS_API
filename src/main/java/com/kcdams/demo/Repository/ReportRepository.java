package com.kcdams.demo.Repository;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin
@Data
public class ReportRepository {

    @Autowired
    public  ReceptionRepository receptionRepository;
    public final RegistrarRepository registrarRepository;
    public final PsychologyRepository psychologyRepository;
    public final NursingRepository nursingRepository;
    public final DoctorRepository doctorRepository;

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


    public Map<String,Object> getAllRegistrar(){
        return registrarRepository.contNumberOfRegister();
    }

    public Map<String,Object> getAllPsychology(){
        return psychologyRepository.countNumberOfPsychologists();
    }

    public Map<String,Object> getAllNursing(){
        return nursingRepository.countNumberOfNurse();
    }

    public Map<String,Object> getAllDoctor(){
        return doctorRepository.countNumberOfDoctor();
    }
}
