package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.VeterinarianDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.NewVeterinarianDTO;
import com.veterinary.veterinaryApp.models.Veterinarian;

import java.util.List;

public interface VeterinarianService {

    List<Veterinarian> getAllVeterinarians();
    Veterinarian getVeterinarianById(Long id);
    List<VeterinarianDTO> getAllVeterinariansDTO();
    void deleteVeterinarian(Long id);
    Veterinarian createVeterinarian(NewVeterinarianDTO newVeterinarianDTO);
    void saveVeterinarian(Veterinarian veterinarian);
}
