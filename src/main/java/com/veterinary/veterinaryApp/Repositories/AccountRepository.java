package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
