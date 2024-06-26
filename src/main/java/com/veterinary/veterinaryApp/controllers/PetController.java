package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.PetDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.NewPetDTO;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Pet;
import com.veterinary.veterinaryApp.services.ClientService;
import com.veterinary.veterinaryApp.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-veterinary/pets")
public class PetController {

  @Autowired
  private PetService petService;

  @Autowired
  private ClientService clientService;

  @PostMapping("/new")
  public ResponseEntity<?> createPet(@RequestBody NewPetDTO newPetDTO, Authentication authentication) {

    Client client = clientService.getCurrentClient(authentication);

    if (newPetDTO.name().isBlank() || newPetDTO.age().isBlank() || newPetDTO.specie().isBlank()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Pet newPet = petService.createPet(newPetDTO);

    if (newPet == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    client.addPet(newPet);
    petService.savePet(newPet);

    return new ResponseEntity<>(new PetDTO(newPet), HttpStatus.CREATED);
  }
}
