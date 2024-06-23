package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.Offering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferingRepository extends JpaRepository<Offering, Long> {
}
