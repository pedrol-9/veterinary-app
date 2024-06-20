package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.Repositories.InvoiceRepository;
import com.veterinary.veterinaryApp.models.Account;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Invoice;
import com.veterinary.veterinaryApp.models.Service;
import com.veterinary.veterinaryApp.services.InvoiceService;
import com.veterinary.veterinaryApp.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ServiceService serviceService;

    //@Autowired
    //private AccountService accountService;


    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<?> createInvoice(Client client, List<Long> serviceIds) {
        //TODO: TENDRIA QUE TENER LA CUENTA DEL CLIENTE POR EL ID
        //List<Account> accounts = accountService.getAccountById(accountId);


        List<Service> services = serviceService.findAllByIds(serviceIds);

        if (services.isEmpty()) {
            return new ResponseEntity<>("No services found.", HttpStatus.NOT_FOUND);
        }

        double totalAmount = calculateTotalAmount(services);

        //CREA  LA FACTURA
        Invoice invoice = new Invoice();
        //invoice.setAccount(account);
        invoice.setServices(services);
        invoice.setDate(LocalDateTime.now());
        invoice.setAmount(totalAmount);
        invoice.setPaid(false); //TODO: SE PUEDE ACTUALIZAR A TRUE CUANDO SE PAGUE

        saveInvoice(invoice);
        //metodo add para poder añadir la factura al cliente o a la cuenta

        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    //METODO PROPIO
    private double calculateTotalAmount(List<Service> services) {
        return services
                .stream()
                .mapToDouble(Service ::getPrice)
                .sum();
    }
}