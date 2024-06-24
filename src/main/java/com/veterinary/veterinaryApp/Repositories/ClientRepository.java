package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);

    Optional<Client> findById (Long id);

    List<Client> findAll();

}
