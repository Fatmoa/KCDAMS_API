package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface RegionRepository extends JpaRepository<Region,Integer> {
    @Query(value = "SELECT * from region WHERE region_code = ?1", nativeQuery = true)
    Optional<Region> checkExisting();

    @Query(value = "SELECT * from region WHERE zone_code = ?1", nativeQuery = true)
    List<Region> allRegionsByZoneCode(int zone_code);

    @Query(value = "SELECT * from region WHERE zone_code = ?1 and region_status = 1", nativeQuery = true)
    List<Region> allRegionsByZoneCodeStatusOne(int zone_code);
}
