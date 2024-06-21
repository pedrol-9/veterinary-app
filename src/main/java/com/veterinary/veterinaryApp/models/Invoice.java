package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Invoice {
    //PROPIEDADES
    //PK
    @Id
    //ID AUTOMATICAMENTE
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime issuedOn;

    private double amount;

    private boolean paid;

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
        this.paid = paid;
        this.status = status;
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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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
}

