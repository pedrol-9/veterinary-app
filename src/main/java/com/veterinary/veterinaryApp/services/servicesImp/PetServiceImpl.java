package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.requestBodys.NewPetDTO;
import com.veterinary.veterinaryApp.Repositories.PetRepository;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Pet;
import com.veterinary.veterinaryApp.services.ClientService;
import com.veterinary.veterinaryApp.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

  @Autowired
  private PetRepository petRepository;

  @Autowired
  private ClientService clientService;

  @Override
  public Pet getPetById(Long id) {
    return petRepository.findById(id).orElse(null);
  }

  @Override
  public void savePet(Pet pet) {
    petRepository.save(pet);
  }

  @Override
  public Pet createPet(NewPetDTO newPetDTO) {
    long ownerId = newPetDTO.ownerId();

    Pet newPet = new Pet(
        newPetDTO.name(),
        newPetDTO.age(),
        newPetDTO.specie(),
        newPetDTO.breed(),
        newPetDTO.animalSize(),
        newPetDTO.specialTreatment(),
        newPetDTO.imageUrl()
    );

    Client client = clientService.getClientById(ownerId);

    client.addPet(newPet);

    savePet(newPet);

    return newPet;
  }
}
