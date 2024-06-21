package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Account;
import com.veterinary.veterinaryApp.models.Invoice;

import java.util.List;

public class AccountDTO {

    private Long id;

    private double balance;

    private long clientId;

    private String clientName;

    private List<Invoice> invoices;

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.balance = account.getBalance();
        this.clientId = account.getClient().getId(); // para que se muestre el id del cliente en el json
        this.clientName = account.getClient().getFirstName() + " " + account.getClient().getLastName(); // para que se muestre el nombre del cliente en el json
        this.invoices = account.getInvoices();
    }

    public Long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public long getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
