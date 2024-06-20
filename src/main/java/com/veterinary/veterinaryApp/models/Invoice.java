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

    private LocalDateTime date;

    private double amount;

    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Relación muchos a muchos con Services
    @ManyToMany(mappedBy = "invoices")
    @JoinColumn(name = "service_id")
    private List<Offering> offerings;

    //CONSTRUCTORES
    public Invoice() {
    }

    public Invoice(LocalDateTime date, double amount, boolean paid, Account account) {
        this.date = date;
        this.amount = amount;
        this.paid = paid;
        this.account = account;
    }

    //GETTERS Y SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public List<Offering> getOfferings() {
        return offerings;
    }

    public void setOfferings(List<Offering> offerings) {
        this.offerings = offerings;
    }
}

