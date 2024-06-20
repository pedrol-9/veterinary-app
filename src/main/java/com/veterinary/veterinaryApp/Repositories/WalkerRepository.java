package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.Walker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalkerRepository extends JpaRepository<Walker, Long> {
}
