package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.OfferingDTO;
import com.veterinary.veterinaryApp.models.Offering;

import java.util.List;

public interface OfferingService {

    List<Offering> getAllOfferings();

    List<OfferingDTO> getAllOfferingsDTO();

    Offering getOfferingById(long id);

    List<Offering> findAllByIds(List<Long> ids);
}