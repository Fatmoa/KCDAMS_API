package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PsychologistRepository extends JpaRepository<Psychologist, Integer> {


    @Query(value = "SELECT * FROM psychologist WHERE py_Id = ?1", nativeQuery = true)
    Optional<Psychologist> checkExistingPsychologist(int pyId);
}
