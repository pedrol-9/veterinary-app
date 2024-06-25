package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Appointment;
import com.veterinary.veterinaryApp.models.Veterinarian;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VeterinarianDTO {

    private Long id;

    private String name;

    private String specialty;

    private String address;

    private String phone;

    private List<Appointment> appointments = new ArrayList<>();

    public VeterinarianDTO() {}

    public VeterinarianDTO(Veterinarian veterinarian) {
        this.id = veterinarian.getId();
        this.name = veterinarian.getName();
        this.specialty = veterinarian.getSpecialty();
        this.address = veterinarian.getAddress();
        this.phone = veterinarian.getPhone();
        this.appointments = veterinarian.getAppointments();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getSpecialty() {
        return specialty;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}
