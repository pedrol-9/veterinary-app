package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Appointment;
import com.veterinary.veterinaryApp.models.Offering;

import java.time.LocalDateTime;
import java.util.List;

public class OfferingDTO {
  
    private long id;

    private String name;

    private String description;

    private List<String> animalSize;

    private List<Double> prices;

//    private List<String> daysOfService;
//
//    private List<String> hoursOfService;

    private List<LocalDateTime> appointments; // Lista de citas de la oferta

    public OfferingDTO(Offering offering) {
        this.id = offering.getId();
        this.name = offering.getName();
        this.description = offering.getDescription();
        this.animalSize = offering.getAnimalSizes();
        this.prices = offering.getPrice();
//        this.daysOfService = offering.getDaysOfService(); // no sé si sea necesario
//        this.hoursOfService = offering.getHoursOfService(); // no sé si sea necesario
        this.appointments = offering.getAppointments().stream().map(Appointment::getDateTime).toList(); // tengo mis dudas, creeería que hay que pasar los objetos completos de appointments para
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Double> getPrice() {
        return prices;
    }
  
    public List<String> getAnimalSize() {
        return animalSize;
    }

    /*public List<String> getDaysOfService() {
        return daysOfService;
    }

    public List<String> getHoursOfService() {
        return hoursOfService;
    }*/

    public List<LocalDateTime> getAppointments() {
        return appointments;
    }
}
