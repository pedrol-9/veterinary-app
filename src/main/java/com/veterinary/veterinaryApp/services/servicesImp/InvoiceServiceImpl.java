package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.InvoiceDTO;
import com.veterinary.veterinaryApp.Repositories.InvoiceRepository;
import com.veterinary.veterinaryApp.models.Appointment;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Invoice;
import com.veterinary.veterinaryApp.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<InvoiceDTO> getAllInvoicesDTO() {
        return getAllInvoices().stream().map(InvoiceDTO::new).collect(Collectors.toList());
    }

    @Override
    public Invoice getInvoiceById(long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Invoice> getInvoicesByAppointmentId(long id) {
        return getAllInvoices().stream().filter(invoice -> invoice.getAppointment().getId() == id).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDTO> getInvoicesByAppointmentIdDTO(List<Invoice> invoices) {
        return invoices.stream().map(InvoiceDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<Invoice> getInvoicesByClient(Client client) {
        return client.getAppointments().stream().map(Appointment::getInvoice).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDTO> getInvoiceByClientDTO(Client client) {
        return getInvoicesByClient(client).stream().map(InvoiceDTO::new).collect(Collectors.toList());
    }


    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }
}