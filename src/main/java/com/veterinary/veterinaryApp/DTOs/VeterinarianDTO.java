package com.veterinary.veterinaryApp.DTOs;

public class VeterinarianDTO {
    private Long id;
    private String name;
    private String specialty;


    public VeterinarianDTO() {}


    public VeterinarianDTO(Long id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }


}
