package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
