package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Account;
import com.veterinary.veterinaryApp.models.Appointment;
import com.veterinary.veterinaryApp.models.Invoice;
import com.veterinary.veterinaryApp.models.InvoiceStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class InvoiceDTO {

    private long id;

    private LocalDateTime issuedOn;

    private double amount;

    private InvoiceStatus status;

    private Account account;

    private Appointment appointment;


    public InvoiceDTO(Invoice invoice) {
        this.id = invoice.getId();
        this.issuedOn = invoice.getIssuedOn();
        this.amount = invoice.getAmount();
        this.status = invoice.getStatus();
        this.account = invoice.getAccount();
        this.appointment = invoice.getAppointment();
    }

    public InvoiceDTO() {
    }

    // Getters
    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getIssuedOn() {
        return issuedOn;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public Account getAccount() {
        return account;
    }

    public Appointment getAppointment() {
        return appointment;
    }
}