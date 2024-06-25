package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.requestBodys.NewVeterinarianDTO;
import com.veterinary.veterinaryApp.models.Veterinarian;
import com.veterinary.veterinaryApp.services.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-veterinarian/veterinarians")
public class VeterinarianController {

  @Autowired
  private VeterinarianService veterinarianService;

  @PostMapping("/new")
  public ResponseEntity<?> createVeterinarian(@RequestBody NewVeterinarianDTO newVeterinarianDTO) {

    if (newVeterinarianDTO.name().isBlank()) {
      return new ResponseEntity<>("phone must not be empty ", HttpStatus.BAD_REQUEST);
    }

    if (newVeterinarianDTO.specialty().isBlank()) {
      return new ResponseEntity<>("specialty must not be empty ", HttpStatus.BAD_REQUEST);
    }

    if (newVeterinarianDTO.address().isBlank()) {
      return new ResponseEntity<>("address must not be empty ", HttpStatus.BAD_REQUEST);
    }

    if (newVeterinarianDTO.phone().isBlank()) {
      return new ResponseEntity<>("phone must not be empty ", HttpStatus.BAD_REQUEST);
    }

    Veterinarian newVeterinarian = veterinarianService.createVeterinarian(newVeterinarianDTO);

    veterinarianService.saveVeterinarian(newVeterinarian);

    return new ResponseEntity<>(newVeterinarian, HttpStatus.CREATED);
  }

}
