package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.AvailableSlots;
import com.veterinary.veterinaryApp.models.Offering;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class AvailableSlotsDTO {

    private long id;

    private LocalDate date;

    private String availableHours;

    private Boolean available;
	
	private String offering;
	
    private DayOfWeek dayOfWeek;

    public AvailableSlotsDTO() {
    }

    public AvailableSlotsDTO(AvailableSlots availableSlots) {

        this.id = availableSlots.getId();
        this.date = availableSlots.getDate();
        this.availableHours = availableSlots.getAvailableHours();
        this.offering = availableSlots.getOffering().getName();
        this.available = availableSlots.getAvailable();
        this.dayOfWeek = availableSlots.getDate().getDayOfWeek();

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

    public String getOffering() {
        return offering;
    }

    public DayOfWeek getDay() {
        return dayOfWeek;
    }

    public long getId() {
        return id;
    }
}
