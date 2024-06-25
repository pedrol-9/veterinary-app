package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.Repositories.PetRepository;
import com.veterinary.veterinaryApp.models.Pet;
import com.veterinary.veterinaryApp.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

  @Autowired
  private PetRepository petRepository;

  @Override
  public Pet getPetById(Long id) {
    return petRepository.findById(id).orElse(null);
  }
}
