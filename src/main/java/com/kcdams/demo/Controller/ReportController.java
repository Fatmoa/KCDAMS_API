package com.kcdams.demo.Controller;

import com.kcdams.demo.Repository.ReportRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/report")
@CrossOrigin
@RestController
@Data
public class ReportController {

    @Autowired
    private final ReportRepository reportRepository;

    @GetMapping("/patientDistrictReport")
    public List<Map<String,Object>> patientDistrictReport(){
        return reportRepository.patientDistrictReport();
    }
    @GetMapping("/patientDateReport")
    public List<Map<String,Object>> patientDateReport(){
        return reportRepository.patientDateReport();
    }

    @GetMapping("/patientGenderReport")
    public List<Map<String,Object>> patientGenderReport(){
        return reportRepository.patientGenderReport();
    }

    @GetMapping("/doctorGenderReport")
    public List<Map<String,Object>> doctorGenderReport(){
        return reportRepository.doctorGenderReport();
    }



    @GetMapping("/summary")
    public ResponseEntity<Map<String, String>> getSummaryReport() {
        Map<String, String> summary = new HashMap<>();
        summary.put("registrars", reportRepository.getAllRegistrar().get("numberOfRegistrar").toString());
        summary.put("psychologists", reportRepository.getAllPsychology().get("numberOfPsychologists").toString());
        summary.put("nurses", reportRepository.getAllNursing().get("numberOfNurse").toString());
        summary.put("doctors", reportRepository.getAllDoctor().get("numberOfDoctor").toString());
        return ResponseEntity.ok(summary);
    }
}
