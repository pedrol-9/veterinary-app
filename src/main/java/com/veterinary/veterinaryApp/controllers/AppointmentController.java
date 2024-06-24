package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

  @Autowired
  private AppointmentService appointmentService;

  @GetMapping("/")
  public ResponseEntity<?> getAllAppointments() {
    return ResponseEntity.ok(appointmentService.getAppointmentDTOs());
  }
}
