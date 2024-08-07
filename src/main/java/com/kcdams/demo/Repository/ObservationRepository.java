package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ObservationRepository extends JpaRepository<Observation,Integer> {
    @Query(value = "SELECT * FROM observation WHERE ob_Id =?1",nativeQuery = true)
    Optional<Observation> checkExistingObservation(int obId);
}
