package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception,String> {


    @Query(value = "SELECT r.mat_code FROM reception r ORDER BY r.mat_code DESC LIMIT 1",nativeQuery = true)
    String findLastMatCode();

    @Query(value = "SELECT * FROM reception where mat_code =?1", nativeQuery = true)
    Optional<Reception> checkExistingReception(int matCode);
}
