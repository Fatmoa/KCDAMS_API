package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Psychology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PsychologyRepository extends JpaRepository<Psychology,Integer> {


    @Query(value = "SELECT * FROM psychology WHERE psy_Id = ?1" ,nativeQuery = true)
    Optional<Psychology> checkExistingPsychology(int psyId);

    @Query(value = "SELECT count(*) as numberOfPsychologists FROM psychology", nativeQuery = true)
    Map<String,Object> countNumberOfPsychologists();

    @Query(value="SELECT count(*) as psychologists, psy_gender as gender FROM psychology "+"GROUP BY psy_gender", nativeQuery = true)
    List<Map<String, Object>> psychologistGenderReport();

}
