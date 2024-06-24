package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.ClientDTO;
import com.veterinary.veterinaryApp.Repositories.ClientRepository;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(ClientDTO::new).collect(toList());
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

   /* @Override
    public List<ClientDTO> getAllClientsDto() {
        return getAllClients().stream().map(ClientDTO::new).collect(toList());
    }*/

    @Override
    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getCurrentClient(Authentication authentication) {
      String email = authentication.getName();
      return getClientByEmail(email);
    }
}
