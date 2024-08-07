package com.kcdams.demo.Services;

import com.kcdams.demo.Models.Psychologist;
import com.kcdams.demo.Repository.PsychologistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class PsychologistService {
    @Autowired
    private  PsychologistRepository psychologistRepository;

    public List<Psychologist> getAllPsychologist() {
        return psychologistRepository.findAll();
    }

    public Psychologist getPsychologistByCode(int pyId) {
        return psychologistRepository.findById(pyId).orElse(null);
    }

    @Transactional
    public Optional<Psychologist> updatePsychologist(int pyId, Psychologist psychologist) {
        return psychologistRepository.findById(pyId).map(z -> {
            z.setPyName(psychologist.getPyName());
            z.setPyMname(psychologist.getPyMname());
            z.setPyLname(psychologist.getPyLname());
            z.setPyGender(psychologist.getPyGender());
            z.setPyEmail(psychologist.getPyEmail());
            z.setPyNumb(psychologist.getPyNumb());
            z.setPyEmplNum(psychologist.getPyEmplNum());
            return z;
        });
    }

    public Psychologist savePsychologist(Psychologist psychologist) {
        Optional<Psychologist> z = psychologistRepository.checkExistingPsychologist(psychologist.getPyId());
        if (z.isEmpty()) {
            return psychologistRepository.save(psychologist);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Psychologist already exists");
        }
    }

    public void deletePsychologist(int pyId) {
        psychologistRepository.deleteById(pyId);
    }


}
