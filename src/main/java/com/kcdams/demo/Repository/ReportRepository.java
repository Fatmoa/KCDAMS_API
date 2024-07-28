package com.kcdams.demo.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    public List<Map<String,Object>> patientDistrictReport(){
        return receptionRepository.patientDistrictReport();
    }

    public List<Map<String,Object>> patientDateReport(){
        return receptionRepository.patientDateReport();
    }
}
