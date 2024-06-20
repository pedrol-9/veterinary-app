package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Service;

import java.util.List;

public class ServiceDTO {
    private long id;

    private String name;

    private String description;

    private double price;

    private List<Long> invoiceId;

    public ServiceDTO(Service service) {
        this.id = service.getId();
        this.name = service.getName();
        this.description = service.getDescription();
        this.price = service.getPrice();

        this.invoiceId = service.getInvoices().stream().map(InvoiceDTO::new).map(InvoiceDTO::getId).toList();

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
