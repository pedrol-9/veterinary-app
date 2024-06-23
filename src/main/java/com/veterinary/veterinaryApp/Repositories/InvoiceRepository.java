package com.veterinary.veterinaryApp.Repositories;

import com.veterinary.veterinaryApp.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
