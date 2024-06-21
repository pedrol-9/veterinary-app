package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime issuedOn;

    private double amount;

    private InvoiceStatus status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    //CONSTRUCTORES
    public Invoice() {
    }

    public Invoice(LocalDateTime issuedOn, double amount, boolean paid, InvoiceStatus status) {
        this.issuedOn = issuedOn;
        this.amount = amount;
        this.status = status;
        this.setStatus(this.getAccount(), this.getAppointment());
    }

    //GETTERS Y SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(LocalDateTime issuedOn) {
        this.issuedOn = issuedOn;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    // Otros metodos
    public void setStatus(Account account, Appointment appointment) {
        this.account = account;
        if (account.getBalance() > 0 || appointment.getAppointmentStatus().equals(AppointmentStatus.SCHEDULED)) {
            this.status = InvoiceStatus.PENDING;
        } else {
            this.status = InvoiceStatus.PAID;
        }

        if (appointment.getAppointmentStatus().equals(AppointmentStatus.CANCELLED)) {
            this.status = InvoiceStatus.CANCELLED;
        } else if (appointment.getAppointmentStatus().equals(AppointmentStatus.CONFIRMED)) {
            this.status = InvoiceStatus.CHARGED;
        }

    }
}

