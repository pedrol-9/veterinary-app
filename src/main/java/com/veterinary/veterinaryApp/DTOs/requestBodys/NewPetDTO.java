package com.veterinary.veterinaryApp.DTOs.requestBodys;

import com.veterinary.veterinaryApp.models.AnimalSize;

public record NewPetDTO(String name, String age, String specie, String breed, AnimalSize animalSize, String specialTreatment, String imageUrl) {}
