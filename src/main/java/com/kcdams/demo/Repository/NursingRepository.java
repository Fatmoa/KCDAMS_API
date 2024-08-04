package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Nursing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NursingRepository extends JpaRepository<Nursing,Integer> {

    @Query(value = "SELECT * FROM nursing WHERE nus_Id=?1",nativeQuery = true)

    Optional<Nursing> checkExistingNursing(int nusId);
}
