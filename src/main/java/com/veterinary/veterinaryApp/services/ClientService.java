package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.ClientDTO;
import com.veterinary.veterinaryApp.models.Client;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<ClientDTO> getAllClients();
    Client getClientById(Long id);
    // List<ClientDTO> getAllClientsDto();
    Client getClientByEmail(String email);
    void saveClient(Client client);
    Client getCurrentClient(Authentication authentication);

}
