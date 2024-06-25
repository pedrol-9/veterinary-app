package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.AvailableSlots;
import com.veterinary.veterinaryApp.models.Offering;

import java.time.LocalDate;
import java.util.List;

public class AvailableSlotsDTO {

    private long id;
    private LocalDate date;
    private String availableHours;
    private Boolean available;
    private Offering offering;

    public AvailableSlotsDTO() {
    }

    public AvailableSlotsDTO(AvailableSlots availableSlots) {

        this.id = availableSlots.getId();
        this.date = availableSlots.getDate();
        this.availableHours = availableSlots.getAvailableHours().toString();
        this.offering = availableSlots.getOffering();
        this.available = availableSlots.getAvailable();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAvailableHours() {
        return availableHours;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Offering getOffering() {
        return offering;
    }

    public long getId() {
        return id;
    }
}
