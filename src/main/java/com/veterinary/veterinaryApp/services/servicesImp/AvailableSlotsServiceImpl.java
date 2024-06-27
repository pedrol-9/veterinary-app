package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.Repositories.AvailableSlotsRepository;
import com.veterinary.veterinaryApp.models.AvailableSlots;
import com.veterinary.veterinaryApp.models.Offering;
import com.veterinary.veterinaryApp.services.AvailableSlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableSlotsServiceImpl implements AvailableSlotsService {

    @Autowired
    AvailableSlotsRepository availableSlotsRepository;

    @Override
    public List<AvailableSlots> getAvailableSlots() {
        return availableSlotsRepository.findAll();
    }

    @Override
    public AvailableSlots getAvailableSlotsById(long id) {
        return availableSlotsRepository.findById(id).orElse(null);
    }

    @Override
    public List<AvailableSlots> getAvailableSlotsByDate() {
        return List.of();
    }

    @Override
    public List<AvailableSlots> getAvailableSlotsByOffering(Offering offering) {
        return availableSlotsRepository.findByOffering(offering);
    }

    @Override
    public void saveAvailableSlots(AvailableSlots availableSlots) {
        availableSlotsRepository.save(availableSlots);
    }
}