package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.OfferingDTO;
import com.veterinary.veterinaryApp.Repositories.OfferingRepository;
import com.veterinary.veterinaryApp.models.AnimalSize;
import com.veterinary.veterinaryApp.models.Offering;
import com.veterinary.veterinaryApp.services.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferingServiceImpl implements OfferingService {

    @Autowired
    private OfferingRepository offeringRepository;

    @Override
    public List<Offering> getAllOfferings() {
        return offeringRepository.findAll();
    }

    @Override
    public List<OfferingDTO> getAllOfferingsDTO() {
        return getAllOfferings().stream().map(OfferingDTO::new).toList();
    }

    @Override
    public Offering getOfferingById(long id) {
        return offeringRepository.findById(id);
    }

    @Override
    public void save(Offering offering) {
        offeringRepository.save(offering);
    }

    @Override
    public double calculatePrice(AnimalSize petSize, double baseRate) {

        double amountToCharge = 0.0;
        if (petSize == AnimalSize.SMALL) {
            amountToCharge = baseRate;
        } else if (petSize == AnimalSize.MEDIUM) {
            amountToCharge = baseRate * 1.25;
        } else if (petSize == AnimalSize.LARGE) {
            amountToCharge = baseRate * 1.5;
        } else if (petSize == AnimalSize.BIGGER) {
            amountToCharge = baseRate * 1.75;
        }

        return amountToCharge;
    }
}