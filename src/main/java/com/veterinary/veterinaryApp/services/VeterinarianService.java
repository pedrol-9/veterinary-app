package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.VeterinarianDTO;
import com.veterinary.veterinaryApp.models.Veterinarian;
import com.veterinary.veterinaryApp.utils.CyclicCounter;

import java.util.List;

public interface VeterinarianService {

    List<Veterinarian> getAllVeterinarians();
    Veterinarian getVeterinarianById(Long id);
    List<VeterinarianDTO> getAllVeterinariansDTO();
    void saveVeterinarian(Veterinarian veterinarian);
    CyclicCounter vetCounter(long start, long end);
}
