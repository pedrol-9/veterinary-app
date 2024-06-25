package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.OfferingDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.NewOfferingDTO;
import com.veterinary.veterinaryApp.models.Offering;
import com.veterinary.veterinaryApp.services.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-veterinary/offerings")
public class OfferingController {

    @Autowired
    OfferingService offeringService;

    @GetMapping("/")
    public ResponseEntity<?> getAllOfferings() {

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
