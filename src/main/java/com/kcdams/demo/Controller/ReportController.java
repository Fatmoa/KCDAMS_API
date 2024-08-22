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

//    @GetMapping("/patientGenderReport")
//    public List<Map<String,Object>> patientGenderReport(){
//        return reportRepository.patientGenderReport();
//    }

    @GetMapping("/doctorGenderReport")
    public List<Map<String,Object>> doctorGenderReport(){
        return reportRepository.doctorGenderReport();
    }

    @GetMapping("/registrarGenderReport")
    public List<Map<String,Object>> registrarGenderReport(){
        return reportRepository.registrarGenderReport();
    }

    @GetMapping("/psychologistGenderReport")
    public List<Map<String,Object>> psychologistGenderReport(){
        return reportRepository.psychologistGenderReport();
    }

    @GetMapping("/nurseGenderReport")
    public List<Map<String,Object>> nurseGenderReport(){
        return reportRepository.nurseGenderReport();
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

    @GetMapping("/patSummary")
    public ResponseEntity<Map<String,String>> getpatSummaryReport(){
        Map<String,String> patsummary = new HashMap<>();
        patsummary.put("males",reportRepository.getMalePatient().get("numberOfMale").toString());
        patsummary.put("females",reportRepository.getFemalePatient().get("numberOfFemale").toString());
        return ResponseEntity.ok(patsummary);
    }
}
