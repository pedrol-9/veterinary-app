package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.InvoiceDTO;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Invoice;
import com.veterinary.veterinaryApp.services.ClientService;
import com.veterinary.veterinaryApp.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-veterinary/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public ResponseEntity<?> getAllInvoices(Authentication authentication) {
        Client client = clientService.getClientByEmail(authentication.getName());
        String role = authentication.getAuthorities().toString();

        if (client == null && !role.equals("[ROLE_ADMIN]")) {
            return new ResponseEntity<>("no esta autorizado", HttpStatus.FORBIDDEN);
        }

        List<InvoiceDTO> invoices = invoiceService.getAllInvoicesDTO();

        //SI NO HAY INVOICES
        if (invoices.isEmpty()) {
            return new ResponseEntity<>("No invoices found.", HttpStatus.NOT_FOUND);
        }

        //SI HAY
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable long id) {
        Invoice invoice = invoiceService.getInvoiceById(id);

        if (invoice == null) {
            return new ResponseEntity<>("No invoice with this id was found.", HttpStatus.NOT_FOUND);
        }
        InvoiceDTO invoiceDTO = new InvoiceDTO(invoice);
        return new ResponseEntity<>(invoiceDTO, HttpStatus.OK);
    }

    @GetMapping("/current/getAll")
    public ResponseEntity<?> getInvoicesByClient(Authentication authentication) {
        Client client = clientService.getClientByEmail(authentication.getName());

        List<InvoiceDTO> invoices = invoiceService.getInvoiceByClientDTO(client);

        if (invoices.isEmpty()) {
            return new ResponseEntity<>("No invoices found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/current/getByAppointment/{id}")
    public ResponseEntity<?> getInvoiceByClient(Authentication authentication, @PathVariable long id) {
        Client client = clientService.getClientByEmail(authentication.getName());
        if (client == null) {
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }

        List<Invoice> invoices = invoiceService.getInvoicesByAppointmentId(id);
        if (invoices.isEmpty()) {
            return new ResponseEntity<>("No invoices found.", HttpStatus.NOT_FOUND);
        }
        List<InvoiceDTO> invoicesDTO = invoiceService.getInvoicesByAppointmentIdDTO(invoices);
        return new ResponseEntity<>(invoicesDTO, HttpStatus.OK);
    }


}
