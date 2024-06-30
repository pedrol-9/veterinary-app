package com.veterinary.app;

import com.veterinary.veterinaryApp.models.Appointment;
import com.veterinary.veterinaryApp.models.AppointmentStatus;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Offering;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

public class AppointmentTest {

    @Test
    public void canCreateAppointment() {
        Appointment appointment = new Appointment(LocalDateTime.now().plusDays(3), LocalDateTime.now(), "Please get my dog a good shower, I´ll pick him up at noon", AppointmentStatus.CONFIRMED);
        assertThat(appointment, notNullValue());
    }

    @Test
    public void canAssignAppointmentToClient() {
        Client lucas = new Client("Lucas", "Gonzalez", "lucas@example.com", "password123", 12345678);
        Appointment appointment1 = new Appointment(LocalDateTime.now().plusDays(3), LocalDateTime.now(), "Please get my dog a good shower, I´ll pick him up at noon", AppointmentStatus.CONFIRMED);

        appointment1.setClient(lucas);

        assertThat(appointment1.getClient(), is(lucas));
    }

    @Test
    public void canAssignAppointmentToService() {
        Appointment appointment1 = new Appointment(LocalDateTime.now().plusDays(3), LocalDateTime.now(), "Please get my dog a good shower, I´ll pick him up at noon", AppointmentStatus.CONFIRMED);
        Offering hospitalisation = new Offering("hospitalisation", "description", 1000,List.of("Monday, Tuesday, Wednesday, Thursday, Friday"), List.of("09:00", "10:00", "11:00"));

        appointment1.setOffering(hospitalisation);

        assertThat(appointment1.getOffering(), is(hospitalisation));
    }
}
