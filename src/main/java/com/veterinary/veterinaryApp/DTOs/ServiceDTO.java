package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Offering;

import java.util.List;

public class ServiceDTO {
    private long id;

    private String name;

    private String description;

    private double price;

    //private List<Long> invoiceId;

    public ServiceDTO(Offering offering) {
        this.id = offering.getId();
        this.name = offering.getName();
        this.description = offering.getDescription();
        this.price = offering.getPrice();

        //this.invoiceId = offering.getInvoices().stream().map(InvoiceDTO::new).map(InvoiceDTO::getId).toList();

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
