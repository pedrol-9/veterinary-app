package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
