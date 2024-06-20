package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.Repositories.ServiceRepository;
import com.veterinary.veterinaryApp.models.Service;
import com.veterinary.veterinaryApp.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Service getServiceById(long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Service> findAllByIds(List<Long> ids) {
        return List.of();
    }
}