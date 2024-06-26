package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.requestBodys.NewPetDTO;
import com.veterinary.veterinaryApp.models.Pet;

public interface PetService {

  Pet getPetById(Long id);

  Pet createPet(NewPetDTO newPetDTO);

  void savePet(Pet pet);

}
