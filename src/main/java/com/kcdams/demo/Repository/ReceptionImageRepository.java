package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReceptionImageRepository extends JpaRepository<Picture,Integer> {

    @Query(value = "SELECT * FROM reception_image WHERE mat_code = ?1",nativeQuery = true)
    Optional<Picture> getReceptionPictureByMatCode(String matCode);
}