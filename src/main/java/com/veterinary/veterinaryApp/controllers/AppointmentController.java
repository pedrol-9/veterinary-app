package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.requestBodys.NewAppointmentDTO;
import com.veterinary.veterinaryApp.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-veterinary/appointments")
public class AppointmentController {

  @Autowired
  private AppointmentService appointmentService;

  @GetMapping("/")
  public ResponseEntity<?> getAllAppointments() {
    return ResponseEntity.ok(appointmentService.getAppointmentDTOs());
  }

  @PostMapping("/")
  public ResponseEntity<?> createAppointment(@RequestBody NewAppointmentDTO newAppointmentDTO, Authentication authentication) {

    return null;
    // ResponseEntity.ok(appointmentService.createAppointment());

  }
}
