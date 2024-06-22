package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
//
//
//    @RequestMapping("/all")
//    public ResponseEntity<?> getAllClients() {
//        return ResponseEntity.ok(clientService.getAllClientsDto());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getClientById(@PathVariable Long id) {
//        return ResponseEntity.ok(clientService.getClientById(id));
//    }

}
