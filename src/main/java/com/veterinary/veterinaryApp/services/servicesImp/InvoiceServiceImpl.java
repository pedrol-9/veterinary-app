package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.InvoiceDTO;
import com.veterinary.veterinaryApp.Repositories.InvoiceRepository;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Invoice;
import com.veterinary.veterinaryApp.models.InvoiceStatus;
import com.veterinary.veterinaryApp.models.Offering;
import com.veterinary.veterinaryApp.services.InvoiceService;
import com.veterinary.veterinaryApp.services.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public List<InvoiceDTO> getAllInvoices() {
        return List.of();
    }

    @Override
    public Invoice getInvoiceById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> createInvoice(Client client, List<Long> serviceIds) {
        return null;
    }

    @Override
    public void saveInvoice(Invoice invoice) {

    }
}