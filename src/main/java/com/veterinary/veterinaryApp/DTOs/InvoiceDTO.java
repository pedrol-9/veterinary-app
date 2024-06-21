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

    private String serviceDescription;

    public InvoiceDTO(Invoice invoice) {
        this.issuedOn = invoice.getIssuedOn();
        this.amount = invoice.getAppointment().getOffering().getPrice();
        this.status = invoice.getStatus();
        this.destinationAccount = invoice.getAccount().getNumber();
        this.billedService = invoice.getAppointment().getOffering().getName();
        this.serviceDescription = invoice.getAppointment().getOffering().getDescription();
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

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public String getBilledService() {
        return billedService;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }
}