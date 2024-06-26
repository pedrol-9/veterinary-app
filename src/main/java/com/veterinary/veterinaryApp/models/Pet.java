package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String petName;

    private String petAge;

    private String specie;

    private String breed;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private AnimalSize animalSize;

    private String specialTreatment;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Client owner;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    // contructores
    public Pet() {}

    public Pet(String petName, String petAge, String specie, String breed, AnimalSize animalSize, String specialTreatment, String imageUrl) {
        this.petName = petName;
        this.petAge = petAge;
        this.specie = specie;
        this.breed = breed;
        this.animalSize = animalSize;
        this.specialTreatment = specialTreatment;
        this.imageUrl = imageUrl;
    }

    public Pet(String name, String age, String specie, String breed, AnimalSize animalSize, String specialTreatment) {
        this.petName = name;
        this.petAge = age;
        this.specie = specie;
        this.breed = breed;
        this.animalSize = animalSize;
        this.specialTreatment = specialTreatment;
    }

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public AnimalSize getAnimalSize() {
        return animalSize;
    }

    public void setAnimalSize(AnimalSize animalSize) {
        this.animalSize = animalSize;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public String getSpecialTreatment() {
        return specialTreatment;
    }

    public void setSpecialTreatment(String specialTreatment) {
        this.specialTreatment = specialTreatment;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointments = appointment;
    }

    // otros metodos
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        appointment.setPet(this);
    }
}
