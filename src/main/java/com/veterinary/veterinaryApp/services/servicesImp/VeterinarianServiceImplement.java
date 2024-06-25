package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.VeterinarianDTO;
import com.veterinary.veterinaryApp.Repositories.VeterinarianRepository;
import com.veterinary.veterinaryApp.models.Veterinarian;
import com.veterinary.veterinaryApp.services.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarianServiceImplement implements VeterinarianService {

    @Autowired
    VeterinarianRepository veterinarianRepository;

    @Override
    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianRepository.findAll();
    }

    @Override
    public Veterinarian getVeterinarianById(Long id) {
        return veterinarianRepository.findById(id).orElse(null);
    }

    @Override
    public List<VeterinarianDTO> getAllVeterinariansDTO() {
        return List.of();
    }

    @Override
    public void saveVeterinarian(Veterinarian veterinarian) {
        veterinarianRepository.save(veterinarian);
    }

}
