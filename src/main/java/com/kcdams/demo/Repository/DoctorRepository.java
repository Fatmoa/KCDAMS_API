package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    @Query(value = "SELECT * FROM doctor WHERE dr_Id =?1",nativeQuery = true)
    Optional<Doctor> checkExistingDoctor(int drId);
}
