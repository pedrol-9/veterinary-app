package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Account;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Invoice;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

public class AccountDTO {

    private Long id;

    private double balance;

    private Client client;

    private List<Invoice> invoices;

    public AccountDTO() {
    }

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.balance = account.getBalance();
        this.client = account.getClient();
        this.invoices = account.getInvoices();
    }
}
