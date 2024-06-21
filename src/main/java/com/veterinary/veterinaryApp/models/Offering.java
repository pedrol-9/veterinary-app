package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Offering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private double price;

    @ElementCollection
    @Column(name="DaysOfService")
    private List<String> daysOfService; // los dias para determinado servicio.

    @ElementCollection
    @Column(name="HoursOfService")
    private List<String> hoursOfService; // los horarios para determinado servicio

    @OneToMany(mappedBy = "service")
    private List<Appointment> appointments; // contiene los bloques horarios reservados

    //CONSTRUCTORES
    public Offering() {
    }

    public Offering(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //GETTERS Y SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getDaysOfService() {
        return daysOfService;
    }

    public void setDaysOfService(List<String> daysOfService) {
        this.daysOfService = daysOfService;
    }

    public List<String> getHoursOfService() {
        return hoursOfService;
    }

    public void setHoursOfService(List<String> hoursOfService) {
        this.hoursOfService = hoursOfService;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}