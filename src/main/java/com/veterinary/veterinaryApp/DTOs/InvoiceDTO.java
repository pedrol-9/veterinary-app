package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Invoice;
import com.veterinary.veterinaryApp.models.InvoiceStatus;

import java.time.LocalDateTime;

public class InvoiceDTO {

    private long id;

    private LocalDateTime issuedOn;

    private double amount;

    private InvoiceStatus status;

    private String destinationAccount;

    private String billedService;

    public InvoiceDTO(Invoice invoice) {
        this.id = invoice.getId();
        this.issuedOn = invoice.getIssuedOn();
        this.amount = invoice.getAppointment().getOffering().getPrice();
        this.status = invoice.getStatus();
        this.destinationAccount = invoice.getAccount().getNumber();
        this.billedService = invoice.getAppointment().getOffering().getName(); // nombre del servicio
    }

    // Getters
    public long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return issuedOn;
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

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public String getBilledService() {
        return billedService;
    }
}