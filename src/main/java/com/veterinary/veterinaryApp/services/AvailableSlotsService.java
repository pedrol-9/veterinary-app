package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.models.AvailableSlots;
import com.veterinary.veterinaryApp.models.Offering;

import java.util.List;

public interface AvailableSlotsService {

    List<AvailableSlots> getAvailableSlots();
    AvailableSlots getAvailableSlotsById(long id);
    List<AvailableSlots> getAvailableSlotsByDate();

    List<AvailableSlots> getAvailableSlotsByOffering(Offering offering);

    void saveAvailableSlots(AvailableSlots availableSlots);

}
