package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String specialty;

    private String address;

    private String phone;

    private String email;
    
    private String image;

    @OneToMany(mappedBy = "veterinarian", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    public Veterinarian(String name, String specialty, String address, String phone, String email, String image) {
        this.name = name;
        this.specialty = specialty;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }

    public Veterinarian() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    // Otros metodos
    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
        appointment.setVeterinarian(this);
    }
}
