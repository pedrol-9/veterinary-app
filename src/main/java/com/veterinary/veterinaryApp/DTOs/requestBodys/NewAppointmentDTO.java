package com.veterinary.veterinaryApp.DTOs.requestBodys;

import com.veterinary.veterinaryApp.models.AppointmentStatus;

import java.time.LocalDateTime;

public record NewAppointmentDTO(LocalDateTime dateTime, String description, AppointmentStatus status, long petId, long offeringId, long slotId) {
}
