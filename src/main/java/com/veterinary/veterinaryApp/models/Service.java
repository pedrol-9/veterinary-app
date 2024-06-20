package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Service {
    //PROPIEDADES
    //PK
    @Id
    //ID AUTOMATICAMENTE
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private double price;

    // Relación muchos a muchos con Invoice
    @ManyToMany(mappedBy = "services")
    private List<Invoice> invoices;

    //CONSTRUCTORES
    public Service() {
    }

    public Service(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //GETTERS Y SETTERS
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public void setPrice(double price) {
        this.price = price;


    }
}