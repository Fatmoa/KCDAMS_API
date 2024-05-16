package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface DrugsRepository extends JpaRepository<Drugs,Integer> {
    @Query(value = "SELECT * FROM drugs WHERE drug_code=?1", nativeQuery = true)

    Optional<Drugs> checkExistingDrugs(int drugCode);
}
