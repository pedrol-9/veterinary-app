package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Invoice;
import com.veterinary.veterinaryApp.models.Offering;
import com.veterinary.veterinaryApp.models.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InvoiceDTO {
    private long id;

    private LocalDateTime date;

    private double amount;

    private boolean paid;

    private long accountId;

    private List<Long> offeringId;

    public InvoiceDTO(Invoice invoice) {
        this.date = invoice.getDate();
        this.amount = invoice.getAmount();
        this.paid = invoice.isPaid();
        this.accountId = invoice.getAccount().getId();
        this.offeringId = invoice.getOfferings().stream().map(Offering::getId).collect(toList());
    }

    // Getters
    public long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public long getAccountId() {
        return accountId;
    }

    public List<Long> getServiceId() {
        return offeringId;
    }
}