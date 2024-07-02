package com.kcdams.demo.Services;

import com.kcdams.demo.Models.Reception;
import com.kcdams.demo.Repository.ReceptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class ReceptionService {
    @Autowired
    private ReceptionRepository receptionRepository;

//    public Reception saveReception(Reception r){
//        Reception rec = new Reception();
//        rec.setMatCode( generateNextMatCode());
//        return receptionRepository.save(rec);
//    }
//
//    @Transactional
//    public  String generateNextMatCode() {
//        String lastMatCode = receptionRepository.findLastMatCode();
//        if (lastMatCode == null || lastMatCode.isEmpty()) {
//            return "MAT01";
//        } else {
//            int lastNumber = Integer.parseInt(lastMatCode.substring(3));
//            return String.format("MAT%02d", lastNumber + 1);
//        }
//    }
//}





    public List<Reception> getAllReception(){
        return receptionRepository.findAll();
    }

    public Reception getReceptionByCode(int matCode) {
        return receptionRepository.findById(matCode).orElse(null);
    }

    @Transactional
    public Optional<Reception> updateReception(int matCode, Reception reception) {
        return receptionRepository.findById(matCode).map(p -> {
            p.setPatFName(reception.getPatFName());
            p.setPatSName(reception.getPatSName());
            p.setPatLName(reception.getPatLName());
            p.setDOB(reception.getDOB());
            p.setPhoneNumber(reception.getPhoneNumber());
            p.setNida(reception.getNida());
            p.setNgoName(reception.getNgoName());
            p.setCowName(reception.getCowName());
            p.setCowPhone(reception.getCowPhone());
            p.setKinName(reception.getKinName());
            p.setKinRelationship(reception.getKinRelationship());
            p.setKinNumber(reception.getKinNumber());
            return p;
        });
    }

    public Reception saveReception(Reception reception) {
        Optional<Reception> z = receptionRepository.checkExistingReception(reception.getMatCode());
        if (z.isEmpty()) {
            return receptionRepository.save(reception);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Err");
        }
    }

    public void deleteReception(int matCode) {
        receptionRepository.deleteById(matCode);
    }
}

