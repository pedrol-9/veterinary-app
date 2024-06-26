package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.AvailableSlots;
import com.veterinary.veterinaryApp.models.Offering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableSlotsRepository extends JpaRepository<AvailableSlots, Long> {
    List<AvailableSlots> findByOffering(Offering offering);
}
