package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.InvoiceDTO;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Invoice;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InvoiceService {

    List<InvoiceDTO> getAllInvoices();

    Invoice getInvoiceById(long id);

    ResponseEntity<?> createInvoice(Client client, List<Long> serviceIds);

    void saveInvoice(Invoice invoice);
}
