package com.kcdams.demo.Services;

import com.kcdams.demo.Models.Ngo;
import com.kcdams.demo.Models.Role;
import com.kcdams.demo.Repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRole(){return roleRepository.findAll();}

    public List<Role> roleStatusOne() {
        return roleRepository.roleStatusOne();
    }

    public Role getRoleByCode(int roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Transactional
    public Optional<Role> updateRole(int roleId, Role role) {
        return roleRepository.findById(roleId).map(r -> {
            r.setRoleName(role.getRoleName());
            r.setRoleStatus(1);
            return r;
        });
    }

    public Role saveRole(Role role) {
        Optional<Role> r = roleRepository.checkExistingRole(role.getRoleId());
        if (r.isEmpty()) {
            return roleRepository.save(role);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Role already exist");
        }
    }

    public void deleteRole(int roleId) {
        roleRepository.deleteById(roleId);
    }
}
