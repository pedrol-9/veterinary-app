package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
