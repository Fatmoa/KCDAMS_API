package com.kcdams.demo.Services;


import com.kcdams.demo.Models.Nursing;
import com.kcdams.demo.Models.Registrar;
import com.kcdams.demo.Repository.NursingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class NursingServices {
    @Autowired
    private NursingRepository nursingRepository;


    public List<Nursing> getAllNursing() { return nursingRepository.findAll();}

    public Nursing getNursingByCode(int nusId) { return nursingRepository.findById(nusId).orElse(null);}

    public Optional<Nursing> updateNursing(int nusId, Nursing nursing) {
        return nursingRepository.findById(nusId).map(n -> {
            n.setNusName(nursing.getNusName());
            n.setNusMname(nursing.getNusMname());
            n.setNusLname(nursing.getNusLname());
            n.setNusGender(nursing.getNusGender());
            n.setNusEmail(nursing.getNusEmail());
            n.setNusPnumb(nursing.getNusPnumb());
            n.setNusemplNum(nursing.getNusemplNum());
            return n;
        });
    }

    public Nursing saveNursing(Nursing nursing) {
        Optional<Nursing> z = nursingRepository.checkExistingNursing(nursing.getNusId());
        if (z.isEmpty()) {
            return nursingRepository.save(nursing);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Nurse already exists");
        }
    }

    public void deleteNursing(int nusId) { nursingRepository.deleteById(nusId);
    }
}
