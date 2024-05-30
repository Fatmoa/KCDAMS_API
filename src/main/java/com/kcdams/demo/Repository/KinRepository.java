package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Kin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface KinRepository extends JpaRepository<Kin, Integer> {
    @Query(value = "SELECT * FROM kins WHERE kin_code =?1", nativeQuery = true)

    Optional<Kin> checkExistingKin(int kinCode);

}
