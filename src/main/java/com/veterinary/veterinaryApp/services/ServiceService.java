package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.models.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceService {
    List<Service> getAllServices();

    Service getServiceById(long id);

    List<Service> findAllByIds(List<Long> ids);
}