package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.ClientDTO;
import com.veterinary.veterinaryApp.Repositories.ClientRepository;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.services.ClientService;

import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<ClientDTO> getAllClientsDto() {
        return getAllClients().stream().map(ClientDTO::new).collect(Collectors.toList());
    }

    @Override
    public void saveClient(Client client) {

    }
}
