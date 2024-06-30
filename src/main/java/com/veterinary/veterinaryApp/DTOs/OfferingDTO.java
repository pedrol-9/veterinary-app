package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Appointment;
import com.veterinary.veterinaryApp.models.Offering;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OfferingDTO {
	
	private long id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	private String image;
	
	private List<String> daysOfService;
	
	private List<String> hoursOfService;
	
	private List<LocalDateTime> appointments; // Lista de citas de la oferta
	
	private Set<AvailableSlotsDTO> availableSlots;
	
	
	public OfferingDTO(Offering offering) {
		this.id = offering.getId();
		this.name = offering.getName();
		this.description = offering.getDescription();
		this.price = offering.getPrice();
		this.appointments = offering.getAppointments().stream().map(Appointment::getDateTime).toList(); // tengo mis dudas, creeería que hay que pasar los objetos completos de appointments para
		this.availableSlots = offering.getAvailableSlots()
						.stream()
						.map(AvailableSlotsDTO::new)
						.collect(Collectors.toSet());
		this.daysOfService = offering.getDaysOfService();
		this.hoursOfService = offering.getHoursOfService();
		this.image = offering.getImage();
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
	
	public double getPrice() {
		return price;
	}
	
	public List<String> getDaysOfService() {
		return daysOfService;
	}
	
	public List<String> getHoursOfService() {
		return hoursOfService;
	}
	
	public List<LocalDateTime> getAppointments() {
		return appointments;
	}
	
	public Set<AvailableSlotsDTO> getAvailableSlots() {
		return availableSlots;
	}
	
	public String getImage() {
		return image;
	}
}
