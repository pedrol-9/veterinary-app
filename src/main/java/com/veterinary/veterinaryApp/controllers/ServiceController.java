package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.models.Offering;
import com.veterinary.veterinaryApp.services.OfferingService;
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
    OfferingService offeringService;
    @GetMapping("/offerings")
    public ResponseEntity<?> getAllOfferings() {
       List<Offering> offerings = offeringService.getAllOfferings();

        if (offerings.isEmpty()) {
            return new ResponseEntity<>("No offerings found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(offerings, HttpStatus.OK);
    }

    @GetMapping("/offerings/{id}")
    public ResponseEntity<?> getOfferingById(@PathVariable long id) {
        Offering offering = offeringService.getOfferingById(id);

        if (offering == null) {
            return new ResponseEntity<>("No offering with this id was found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(offering, HttpStatus.OK);
    }
}
