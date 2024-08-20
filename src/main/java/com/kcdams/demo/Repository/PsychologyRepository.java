package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Psychology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;
import java.util.Optional;

public interface PsychologyRepository extends JpaRepository<Psychology,Integer> {


    @Query(value = "SELECT * FROM psychology WHERE psy_Id = ?1" ,nativeQuery = true)
    Optional<Psychology> checkExistingPsychology(int psyId);

    @Query(value = "SELECT count(*) as numberOfPsychologists FROM psychology", nativeQuery = true)
    Map<String,Object> countNumberOfPsychologists();
}
