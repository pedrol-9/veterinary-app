package com.veterinary.veterinaryApp.DTOs;

public class PetDTO {

    private Long id;
    private String petName;
    private int petAge;
    private String specie;
    private String breed;


    public PetDTO() {}


    public PetDTO(Long id, String petName, int petAge, String specie, String breed) {
        this.id = id;
        this.petName = petName;
        this.petAge = petAge;
        this.specie = specie;
        this.breed = breed;
    }

    public Long getId() {
        return id;
    }

    public String getPetName() {
        return petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public String getSpecie() {
        return specie;
    }

    public String getBreed() {
        return breed;
    }
}
