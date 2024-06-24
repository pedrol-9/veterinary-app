package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.VeterinarianDTO;
import com.veterinary.veterinaryApp.models.Veterinarian;

import java.util.List;

public interface VeterinarianService {

    List<Veterinarian> getAllVeterinarians();
    Veterinarian findVeterinarianById(Long id);
    List<VeterinarianDTO> getAllVeterinariansDTO();
    void saveVeterinarian(Veterinarian veterinarian);
}
