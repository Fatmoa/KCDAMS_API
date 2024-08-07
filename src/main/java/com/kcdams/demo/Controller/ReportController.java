package com.kcdams.demo.Controller;

import com.kcdams.demo.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/report")
@CrossOrigin
@RestController
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/patientDistrictReport")
    public List<Map<String,Object>> patientDistrictReport(){
        return reportRepository.patientDistrictReport();
    }
    @GetMapping("/patientDateReport")
    public List<Map<String,Object>> patientDateReport(){
        return reportRepository.patientDateReport();
    }

}
