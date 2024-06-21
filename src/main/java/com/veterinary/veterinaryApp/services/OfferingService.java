package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.models.Offering;

import java.util.List;

public interface OfferingService {
    List<Offering> getAllOfferings();

    Offering getOfferingById(long id);

    List<Offering> findAllByIds(List<Long> ids);
}