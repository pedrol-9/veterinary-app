package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Offering;
import com.veterinary.veterinaryApp.models.Pet;
import com.veterinary.veterinaryApp.models.Veterinarian;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class AppointmentDTO {
    private Long id;

    private LocalDateTime dateTime;
    private Veterinarian veterinarian;
    private Client client;
    private Pet pet;
    private Offering offering;

    public AppointmentDTO() {
    }
}
