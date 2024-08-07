package com.kcdams.demo.Services;


import com.kcdams.demo.Models.Psychology;
import com.kcdams.demo.Repository.PsychologyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class PsychologyService {
    @Autowired
    private PsychologyRepository psychologyRepository;
    public List<Psychology> getAllPsychology() {
        return psychologyRepository.findAll();
    }

    public Psychology getPsychologyByCode(int psyId) {
        return psychologyRepository.findById(psyId).orElse(null);
    }

    @Transactional
    public Optional<Psychology> updatePsychology(int psyId, Psychology psychology) {
        return psychologyRepository.findById(psyId).map(z -> {
            z.setPsyName(psychology.getPsyName());
            z.setPsyMname(psychology.getPsyMname());
            z.setPsyLname(psychology.getPsyLname());
            z.setPsyGender(psychology.getPsyGender());
            z.setPsyEmail(psychology.getPsyEmail());
            z.setPsyNumb(psychology.getPsyNumb());
            z.setPsyEmplNum(psychology.getPsyEmplNum());
            return z;
        });
    }

    public Psychology savePsychology(Psychology psychology) {
        Optional<Psychology> z = psychologyRepository.checkExistingPsychology(psychology.getPsyId());
        if (z.isEmpty()) {
            return psychologyRepository.save(psychology);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Psychology already exists");
        }
    }

    public void deletePsychology(int psyId) {
        psychologyRepository.deleteById(psyId);
    }


}
