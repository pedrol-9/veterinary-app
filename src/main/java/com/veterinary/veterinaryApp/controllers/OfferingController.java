package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.OfferingDTO;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Offering;
import com.veterinary.veterinaryApp.services.ClientService;
import com.veterinary.veterinaryApp.services.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-veterinary/offerings")
public class OfferingController {

    @Autowired
    OfferingService offeringService;
    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public ResponseEntity<?> getAllOfferings() {
//        Client client = clientService.getClientByEmail(authentication.getName());
//        String role = authentication.getAuthorities().toString();
//
//        if (client == null || role != "ADMIN") {
//            return new ResponseEntity<>("No ADMIN with this email was found.", HttpStatus.NOT_FOUND);
//        }

        List<OfferingDTO> offerings = offeringService.getAllOfferingsDTO();

        if (offerings.isEmpty()) {
            return new ResponseEntity<>("No offerings found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(offerings, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOfferingById(@PathVariable long id) {
        Offering offering = offeringService.getOfferingById(id);

        if (offering == null) {
            return new ResponseEntity<>("No offering with this id was found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new OfferingDTO(offering), HttpStatus.OK);
    }
}
