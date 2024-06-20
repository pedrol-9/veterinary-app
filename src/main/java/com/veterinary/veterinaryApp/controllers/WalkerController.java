package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.WalkerDTO;
import com.veterinary.veterinaryApp.models.Walker;
import com.veterinary.veterinaryApp.services.WalkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/walkers")
public class WalkerController {

    @Autowired
    private WalkerService walkerService;

    // Método GET para obtener todos los Walkers
    @GetMapping("/all")
    public ResponseEntity<?> getAllWalkers() {
        List<Walker> walkersList = walkerService.getAllWalkers();
        List<WalkerDTO> walkersDTOList = walkerService.getAllWalkersDto(new WalkerDTO());

        if (walkersList.isEmpty()) {
            return new ResponseEntity<>("No se encontraron paseadores", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(walkersDTOList);
    }

    @GetMapping("/walker/{id}")
    public ResponseEntity<?> getWalkerById(@PathVariable Long id) {
        Walker walker = walkerService.getWalkerById(id);
        if (walker == null) {
            return new ResponseEntity<>("Paseador no encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(walker);
    }

    // Método POST para crear un nuevo Walker
    @PostMapping("/create")
    public ResponseEntity<?> createWalker(@RequestBody  Walker walker) {
        walkerService.saveWalker(walker);
        return ResponseEntity.ok("Paseador creado con exito");
    }
}
