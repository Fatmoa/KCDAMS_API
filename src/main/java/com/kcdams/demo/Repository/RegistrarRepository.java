package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Registrar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RegistrarRepository extends JpaRepository<Registrar,Integer> {

    @Query(value = "SELECT * FROM registrar WHERE reg_Id = ?1", nativeQuery = true)
    Optional<Registrar> checkExistingRegistrar(int regId);

}
