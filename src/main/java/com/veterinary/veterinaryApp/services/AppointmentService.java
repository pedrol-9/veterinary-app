package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.AppointmentDTO;
import com.veterinary.veterinaryApp.models.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    List<Appointment> getAllAppointments();
    List<AppointmentDTO> getAppointmentDTOs();
    Appointment getAppointmentById(Long id);
    void createAppointment(Appointment appointment);

}
