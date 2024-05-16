package com.kcdams.demo.Repository;


import com.kcdams.demo.Models.Shehia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

    public interface ShehiaRepository extends JpaRepository<Shehia, Integer> {
    @Query(value = "SELECT * FROM shehia WHERE shehia_code =?1", nativeQuery = true)
    Optional <Shehia> checkExistingShehia(int shehia_code);

    @Query(value = "SELECT * FROM shehia WHERE district_code = ?1 and shehia_status = 1", nativeQuery = true)
    List<Shehia> allShehiaByDistrictStatusOne(int district_code);

}
