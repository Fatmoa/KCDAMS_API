package com.kcdams.demo.Controller;

import com.kcdams.demo.Models.Registrar;
import com.kcdams.demo.Services.RegistrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registrar")
@CrossOrigin

public class RegistrarController {
    @Autowired
    private RegistrarService registrarService;

    @GetMapping("/all")
    public List<Registrar> getAllRegistrar() {
        return registrarService.getAllRegistrar();
    }

    @GetMapping("/{regId}")
    public ResponseEntity<Registrar> getRegistrarByCode(@PathVariable int regId) {
        Registrar registrar = registrarService.getRegistrarByCode(regId);
        return registrar != null ? new ResponseEntity<>(registrar, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editRegistrar/{id}")
    public Optional<Registrar> updateRegistrar(@PathVariable("id") int id, @RequestBody Registrar registrar) {
        return registrarService.updateRegistrar(id, registrar);
    }

    @PostMapping("/save")
    public ResponseEntity<Registrar> createRegistrar(@RequestBody Registrar registrar) {
        Registrar savedRegistrar = registrarService.saveRegistrar(registrar);
        return new ResponseEntity<>(savedRegistrar, HttpStatus.CREATED);
    }

    @DeleteMapping("/{regId}")
    public ResponseEntity<Void> deleteRegistrar(@PathVariable int regId) {
        registrarService.deleteRegistrar(regId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
