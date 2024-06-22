package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.ClientDTO;
import com.veterinary.veterinaryApp.models.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(Long id);
    List<ClientDTO> getAllClientsDto(Client client);
    Client getClientByEmail(String email);
    void saveClient(Client client);
}
