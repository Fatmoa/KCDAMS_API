package com.kcdams.demo.Controller;


import com.kcdams.demo.Models.Ngo;
import com.kcdams.demo.Models.Role;
import com.kcdams.demo.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin

public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role savedRole = roleService.saveRole(role);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Role> getAllRole(){
        return roleService.getAllRole();
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<Role> getRoleByCode(@PathVariable int roleId){
        Role role = roleService.getRoleByCode(roleId);
        return role != null ? new ResponseEntity<>(role, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("roleStatusOne")
    public List<Role>  roleStatusOne(){
        return roleService.roleStatusOne();
    }

    @PutMapping("/editRole/{id}")
    public Optional<Role> updateRole(@PathVariable("id") int id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable int roleId) {
        roleService.deleteRole(roleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byRoleName/{roleName}")
    public Optional<Role> byRoleName(@PathVariable("roleName") String roleName){
        return roleService.roleByName(roleName);
    }
}
