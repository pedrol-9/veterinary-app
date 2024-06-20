package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.WalkerDTO;
import com.veterinary.veterinaryApp.models.Walker;

import java.util.List;

public interface WalkerService {
    List<Walker> getAllWalkers();
    List<WalkerDTO> getAllWalkersDto(WalkerDTO walkerDTO);
    Walker getWalkerById(Long id);
    void saveWalker(Walker walker);
}
