package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Pet;

import java.time.LocalDateTime;

public class PetDTO {

    private Long id;

    private String petName;

    private int petAge;

    private String specie;

    private String breed;

    private String specialTreatment;

    private LocalDateTime appointmentDate; // asumiendo que tiene una sola cita por mascota

    private String owner;

    public PetDTO() {}

    public PetDTO(Pet pet) {
        this.id = pet.getId();
        this.petName = pet.getPetName();
        this.petAge = pet.getPetAge();
        this.specie = pet.getSpecie();
        this.breed = pet.getBreed();
        this.specialTreatment = pet.getSpecialTreatment();
        this.appointmentDate = pet.getAppointment().getDateTime(); // creo que la relación mascota tiene una relación OneToOne con Appointment porque el Client es quien puede tener varios appointments y la pet es quien puede tener un appointment por cada vez que se crea un appointment
        this.owner = pet.getOwner().getFirstName() + " " + pet.getOwner().getLastName();
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

    public String getSpecialTreatment() {
        return specialTreatment;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public String getOwner() {
        return owner;
    }
}
