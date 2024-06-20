package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.Repositories.ServiceRepository;
import com.veterinary.veterinaryApp.models.Service;
import com.veterinary.veterinaryApp.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/veterinary")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/services")
    public ResponseEntity<?> getAllServices() {
       List<Service> services = serviceService.getAllServices();

        if (services.isEmpty()) {
            return new ResponseEntity<>("No services found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable long id) {
        Service service = serviceService.getServiceById(id);

        if (service == null) {
            return new ResponseEntity<>("No service with this id was found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(service, HttpStatus.OK);
    }
}
