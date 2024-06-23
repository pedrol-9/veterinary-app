package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.models.Offering;
import com.veterinary.veterinaryApp.services.OfferingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferingServiceImpl implements OfferingService {

    @Override
    public List<Offering> getAllOfferings() {
        return List.of();
    }

    @Override
    public Offering getOfferingById(long id) {
        return null;
    }

    @Override
    public List<Offering> findAllByIds(List<Long> ids) {
        return List.of();
    }
}