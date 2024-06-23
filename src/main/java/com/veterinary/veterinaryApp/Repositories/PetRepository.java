package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
