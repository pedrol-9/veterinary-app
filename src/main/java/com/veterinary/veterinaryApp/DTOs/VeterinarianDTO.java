package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Appointment;
import com.veterinary.veterinaryApp.models.Veterinarian;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

public class VeterinarianDTO {

    private Long id;

    private String name;

    private String specialty;

    private List<LocalDateTime> appointments; // lista solamente de fecha y tiempo de las citas

    public VeterinarianDTO() {}

    public VeterinarianDTO(Veterinarian veterinarian) {
        this.id = veterinarian.getId();
        this.name = veterinarian.getName();
        this.specialty = veterinarian.getSpecialty();
        this.appointments = veterinarian.getAppointments().stream().map(Appointment::getDateTime).toList();
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

    public List<LocalDateTime> getAppointments() {
        return appointments;
    }
}
