package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class InvoiceDTO {

    private long id;

    private LocalDateTime issuedOn;

    private double amount;

    private InvoiceStatus status;

    private long account;

    private long appointment;

    private String offering;

    private String offeringDescription;

    public InvoiceDTO(Invoice invoice) {
        this.id = invoice.getId();
        this.issuedOn = invoice.getIssuedOn();
        this.amount = invoice.getAmount();
        this.status = invoice.getStatus();
        this.account = invoice.getAccount().getId();
        this.appointment = invoice.getAppointment().getId();
        this.offering = invoice.getAppointment().getOffering().getName();
        this.offeringDescription = invoice.getAppointment().getOffering().getDescription();
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

    public long getAccount() {
        return account;
    }

    public long getAppointment() {
        return appointment;
    }

    public String getOffering() {
        return offering;
    }

    public String getOfferingDescription() {
        return offeringDescription;
    }
}