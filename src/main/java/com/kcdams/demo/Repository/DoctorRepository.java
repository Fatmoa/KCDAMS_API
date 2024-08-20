package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    @Query(value = "SELECT * FROM doctor WHERE dr_Id =?1",nativeQuery = true)
    Optional<Doctor> checkExistingDoctor(int drId);



    @Query(value = "SELECT count(*) as doctors, d.dr_gender as gender FROM doctor d " +
            "GROUP BY d.dr_gender", nativeQuery = true)
    List<Map<String, Object>> doctorGenderReport();

    @Query(value = "SELECT count(*) as numberOfDoctor FROM doctor",nativeQuery = true)
    Map<String, Object> countNumberOfDoctor();
}
