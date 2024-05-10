package com.kcdams.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kcdams.demo.Models.Zone;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer> {
    @Query(value = "SELECT * FROM zone WHERE zone_code = ?1", nativeQuery = true)
    Optional<Zone> checkExistingZone(int zoneCode);

    @Query(value = "SELECT * FROM zone WHERE zone_status = 1", nativeQuery = true)
    List<Zone> zoneStatusOne();
}
