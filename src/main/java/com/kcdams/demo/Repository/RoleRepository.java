package com.kcdams.demo.Repository;

import com.kcdams.demo.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "SELECT * FROM role WHERE role_id=?1",nativeQuery = true)
    Optional<Role> checkExistingRole(int roleId);

    @Query(value = "SELECT * FROM role WHERE role_name=?1",nativeQuery = true)
    Optional<Role> rolebyName(String roleName);

   @Query(value = "SELECT * FROM role WHERE role_status =1", nativeQuery = true)
    List<Role> roleStatusOne();

}
