package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Entity
public class AvailableSlots {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private LocalDate date;
    
    private String availableHours;
    
    private Boolean available;
//    @Transient
    private DayOfWeek dayOfWeek;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "offering_id")
    private Offering offering;

    public AvailableSlots() {
    }

    public AvailableSlots(LocalDate date, String availableHours, Offering offering) {
        this.date = date;
        this.availableHours = availableHours;
        this.offering = offering;
        this.available = true;
        this.dayOfWeek = date.getDayOfWeek();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(String availableHours) {
        this.availableHours = availableHours;
    }

    public Offering getOffering() {
        return offering;
    }

    public void setOffering(Offering offering) {
        this.offering = offering;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
