package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Appointment;
import com.veterinary.veterinaryApp.models.Offering;
import jakarta.persistence.*;

import java.util.List;

public class OfferingDTO {

    private long id;

    private String name;

    private String description;

    private double price;

    private List<String> daysOfService; // los dias para determinado servicio.

    private List<String> hoursOfService; // los horarios para determinado servicio

    private List<Appointment> appointments; // contiene los bloques horarios reservados


    public OfferingDTO(Offering offering) {
        this.id = offering.getId();
        this.name = offering.getName();
        this.description = offering.getDescription();
        this.price = offering.getPrice();
        this.daysOfService = offering.getDaysOfService();
        this.hoursOfService = offering.getHoursOfService();
        this.appointments = offering.getAppointments();
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<String> getHoursOfService() {
        return hoursOfService;
    }

    public List<String> getDaysOfService() {
        return daysOfService;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
