package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
}
