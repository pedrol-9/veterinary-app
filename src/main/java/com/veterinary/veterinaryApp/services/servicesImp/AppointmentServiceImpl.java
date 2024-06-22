package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.AppointmentDTO;
import com.veterinary.veterinaryApp.Repositories.AppointmentRepository;
import com.veterinary.veterinaryApp.models.Appointment;
import com.veterinary.veterinaryApp.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<AppointmentDTO> getAppointmentDTOs() {
        return getAllAppointments().stream().map(AppointmentDTO::new).toList();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public void createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
