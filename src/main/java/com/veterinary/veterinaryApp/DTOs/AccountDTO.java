package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Account;
import com.veterinary.veterinaryApp.models.Invoice;

import java.util.List;

public class AccountDTO {

    private Long id;

    private double balance;

    private String accountNumber;

    private long clientId;

    private String clientName;

    private List<InvoiceDTO> chargedInvoices;

    public AccountDTO(Account account) {

        List<Invoice> invoicesAux = account.getInvoices().stream().filter(i -> i.getStatus().name().equals("CHARGED")).toList(); // para que solo aparezcan las facturas cargadas a las cuentas, no las facturas pendientes.

        this.id = account.getId();
        this.balance = account.getBalance();
        this.accountNumber = account.getNumber();
        this.clientId = account.getClient().getId();
        this.clientName = account.getClient().getFirstName() + " " + account.getClient().getLastName();
        this.chargedInvoices = invoicesAux.stream().map(InvoiceDTO::new).toList();

    }

    public Long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public List<InvoiceDTO> getChargedInvoices() {
        return chargedInvoices;
    }
}
