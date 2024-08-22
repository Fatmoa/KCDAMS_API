package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Nursing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface NursingRepository extends JpaRepository<Nursing,Integer> {

    @Query(value = "SELECT * FROM nursing WHERE nus_Id=?1",nativeQuery = true)

    Optional<Nursing> checkExistingNursing(int nusId);

    @Query(value = "SELECT count(*) as numberOfNurse FROM nursing", nativeQuery = true)
    Map<String, Object> countNumberOfNurse();

    @Query(value = "SELECT count(*) as nurses, nus_gender as gender FROM nursing " + "GROUP BY nus_gender",nativeQuery = true)
    List<Map<String, Object>> nurseGenderReport();
}
