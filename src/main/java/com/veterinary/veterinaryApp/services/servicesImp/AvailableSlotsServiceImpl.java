package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.Repositories.AvailableSlotsRepository;
import com.veterinary.veterinaryApp.models.AvailableSlots;
import com.veterinary.veterinaryApp.models.Offering;
import com.veterinary.veterinaryApp.services.AvailableSlotsService;

import java.util.List;

public class AvailableSlotsServiceImpl implements AvailableSlotsService {

    AvailableSlotsRepository availableSlotsRepository;

    @Override
    public List<AvailableSlots> getAvailableSlots() {
        return availableSlotsRepository.findAll();
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