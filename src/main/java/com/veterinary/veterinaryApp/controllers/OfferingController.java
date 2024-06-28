package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.OfferingDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.NewOfferingDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.UpdateOfferingDTO;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Offering;
import com.veterinary.veterinaryApp.services.ClientService;
import com.veterinary.veterinaryApp.services.OfferingService;
import com.veterinary.veterinaryApp.utils.Utils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @PostMapping("/create")
    public ResponseEntity<?> createOffering(@Valid @RequestBody NewOfferingDTO newOfferingDTO) {

        try {

          Offering newOffering = offeringService.createOffering(newOfferingDTO);
          List<String> daysOfService = Utils.generateNextSevenDays();
          List<String> hoursOfServiceSlots = Utils.hoursOfServiceSlots;
            newOffering.setDaysOfService(daysOfService);
            newOffering.setHoursOfService(hoursOfServiceSlots);
            offeringService.saveOffering(newOffering);

          return new ResponseEntity<>(new OfferingDTO(newOffering), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


  @PutMapping("/update-price")
  public ResponseEntity<?> updateServicePrice(@Valid @RequestBody UpdateOfferingDTO updateOffering) {
    try {
      long offeringId = updateOffering.id();
      Offering existingService = offeringService.getOfferingById(offeringId);

      if (existingService == null) {
        return new ResponseEntity<>("No Service was found with ID: " + offeringId, HttpStatus.NOT_FOUND);
      }

      double newPrice = updateOffering.price();

      offeringService.updatePrice(existingService, newPrice);

      return new ResponseEntity<>("Price updated for service: " + existingService.getName(), HttpStatus.OK);
    } catch (Exception e) {
      // Manejo genérico de excepciones
      return new ResponseEntity<>("Error updating service price: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
