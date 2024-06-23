package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.VeterinarianDTO;
import com.veterinary.veterinaryApp.Repositories.VeterinarianRepository;
import com.veterinary.veterinaryApp.models.Veterinarian;
import com.veterinary.veterinaryApp.services.VeterinarianService;

import java.util.List;

public class VeterinarianServiceImplement implements VeterinarianService {

    VeterinarianRepository veterinarianRepository;

    @Override
    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianRepository.findAll();
    }

    @Override
    public Veterinarian findVeterinarianById(Long id) {
        return veterinarianRepository.findById(id).orElse(null);
    }

    @Override
    public List<VeterinarianDTO> getAllVeterinariansDTO() {
        return getAllVeterinarians().stream().filter(veterinarian -> veterinarian.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void saveVeterinarian(Veterinarian veterinarian) {
        veterinarianRepository.save(veterinarian);
    }
}
