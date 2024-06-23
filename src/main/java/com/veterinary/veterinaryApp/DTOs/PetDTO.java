package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Appointment;
import com.veterinary.veterinaryApp.models.AppointmentStatus;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Pet;

import java.time.LocalDateTime;
import java.util.List;

public class PetDTO {

    private Long id;

    private String petName;

    private int petAge;

    private String specie;

    private String breed;

    private String specialTreatment;

    private List<LocalDateTime> appointmentDate; // asumiendo que tiene una sola cita por mascota

    private String owner;

    public PetDTO() {}

    public PetDTO(Pet pet) {
        this.id = pet.getId();
        this.petName = pet.getPetName();
        this.petAge = pet.getPetAge();
        this.specie = pet.getSpecie();
        this.breed = pet.getBreed();
        this.specialTreatment = pet.getSpecialTreatment();
        this.appointmentDate =  pet.getAppointments().stream().map(Appointment::getDateTime).toList();
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

    public List<LocalDateTime> getAppointmentDate() {
        return appointmentDate;
    }

    public String getOwner() {
        return owner;
    }
}
