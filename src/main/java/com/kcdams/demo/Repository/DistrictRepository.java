package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface DistrictRepository extends JpaRepository<District,Integer> {
    @Query(value = "SELECT * FROM district WHERE district_code = ?1", nativeQuery = true)
    Optional<District> checkExistingDistrict(int district_code);

    @Query(value = "SELECT * FROM district WHERE region_code = ?1 and district_status = 1", nativeQuery = true)
    List<District> allDistrictByRegionStatusOne(int region_code);
}
