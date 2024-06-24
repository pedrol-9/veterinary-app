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

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private OfferingService offeringService;


    @Override
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll().stream().map(InvoiceDTO::new).toList();
    }

    @Override
    public Invoice getInvoiceById(long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<?> createInvoice(Client client, List<Long> offeringsIds) {
        //TODO: TENDRIA QUE TENER LA CUENTA DEL CLIENTE POR EL ID
        //List<Account> accounts = accountService.getAccountById(accountId);

        List<Offering> offerings = offeringService.findAllByIds(offeringsIds);

        if (offerings.isEmpty()) {
            return new ResponseEntity<>("No offerings found.", HttpStatus.NOT_FOUND);
        }

        double totalAmount = calculateTotalAmount(offerings);

        //CREA  LA FACTURA
        Invoice invoice = new Invoice();
        //invoice.setAccount(account);
        // invoice.setOfferings(offerings);
        invoice.setIssuedOn(LocalDateTime.now());
        invoice.setAmount(totalAmount);
        invoice.setStatus(InvoiceStatus.PAID); //TODO: SE PUEDE ACTUALIZAR A TRUE CUANDO SE PAGUE

        saveInvoice(invoice);
        //metodo add para poder añadir la factura al cliente o a la cuenta

        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    //METODO PROPIO
    private double calculateTotalAmount(List<Offering> offerings) {
        return offerings
                .stream()
                .mapToDouble(Offering ::getPrice)
                .sum();
    }
}