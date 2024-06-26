package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.InvoiceDTO;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Invoice;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoices();
    List<InvoiceDTO> getAllInvoicesDTO();
    Invoice getInvoiceById(long id);
    List<Invoice> getInvoicesByAppointmentId(long id);
    List<InvoiceDTO> getInvoicesByAppointmentIdDTO(List<Invoice> invoices);
    List<Invoice> getInvoicesByClient(Client client);
    List<InvoiceDTO> getInvoiceByClientDTO(Client client);

    void saveInvoice(Invoice invoice);
}
