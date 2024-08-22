package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception,String> {

    @Query(value = "SELECT r.mat_code FROM reception r ORDER BY r.mat_code DESC LIMIT 1",nativeQuery = true)
    String findLastMatCode();

    @Query(value = "SELECT * FROM reception where mat_code =?1", nativeQuery = true)
    Optional<Reception> checkExistingReception(int matCode);

    @Query(value = "SELECT count(*) as receptions, d.district_name from reception r,district d WHERE d.district_code = r.district_code " +
            "GROUP BY d.district_name", nativeQuery = true)
    List<Map<String,Object>> patientDistrictReport();

    @Query(value = "SELECT count(*) as receptions,MONTH(r.dob) as month from reception r " +
            "GROUP BY MONTH(r.dob)", nativeQuery = true)
    List<Map<String,Object>> patientDateReport();



//    @Query(value = "SELECT count(*) as Malereceptions,gender from reception WHERE gender ='Male'" +
//            "GROUP BY gender", nativeQuery = true)
//    List<Map<String,Object>> patientGenderReport();

    @Query(value = "SELECT count(*) as numberOfMale, gender FROM reception WHERE gender ='Male'",nativeQuery = true)
    Map<String, Object> countNumberOfMale();

    @Query(value = "SELECT count(*) as numberOfFemale, gender FROM reception WHERE gender ='Female'",nativeQuery = true)
    Map<String, Object> countNumberOfFemale();


}
