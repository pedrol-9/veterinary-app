package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Client, Long> {

}
