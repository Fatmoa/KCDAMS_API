package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Registrar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RegistrarRepository extends JpaRepository<Registrar,Integer> {

    @Query(value = "SELECT * FROM registrar WHERE reg_Id = ?1", nativeQuery = true)
    Optional<Registrar> checkExistingRegistrar(int regId);

    @Query(value = "SELECT count(*) as numberOfRegistrar FROM registrar", nativeQuery = true)
    Map<String,Object> contNumberOfRegister();

    @Query(value = "SELECT count(*) as registrars, resi_gender as gender FROM registrar " + "GROUP BY resi_gender",nativeQuery = true)
    List<Map<String, Object>> registrarGenderReport();
}
