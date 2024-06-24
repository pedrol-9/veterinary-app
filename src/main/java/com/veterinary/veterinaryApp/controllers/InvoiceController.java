package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.InvoiceDTO;
import com.veterinary.veterinaryApp.models.Invoice;
import com.veterinary.veterinaryApp.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-veterinary/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/")
    public ResponseEntity<?> getAllInvoices() {
        List<InvoiceDTO> invoices = invoiceService.getAllInvoices();

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

        if (invoice == null){
            return new ResponseEntity<>("No invoice with this id was found.", HttpStatus.NOT_FOUND);
        }
        InvoiceDTO invoiceDTO = new InvoiceDTO(invoice);
        return new ResponseEntity<>(invoiceDTO, HttpStatus.OK);
    }

/*    @PostMapping("create/invoice")
    public ResponseEntity<?> createInvoice(@RequestBody InvoiceDTO invoiceDTO) { //CREAR RECORD
    }*/
}
