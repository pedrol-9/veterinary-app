package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.AppointmentDTO;
import com.veterinary.veterinaryApp.models.*;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    List<Appointment> getAllAppointments();
    List<AppointmentDTO> getAppointmentDTOs();
    Appointment getAppointmentById(Long id);
    void saveAppointment(Appointment appointment);
    void setEntities(Appointment appointment, Client client, Pet pet, Veterinarian veterinarian, Offering offering, Invoice invoice);
}
