package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Ngo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NgoRepository extends JpaRepository<Ngo,Integer> {
    @Query(value = "SELECT * from ngo WHERE ngo_code = ?1", nativeQuery = true )

    Optional<Ngo> checkExistingNgo(int ngoCode);

    @Query(value = "SELECT * from ngo WHERE ngo_status =1", nativeQuery = true)
    List<Ngo> ngoStatusOne();


}
