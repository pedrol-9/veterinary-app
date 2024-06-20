package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.WalkerDTO;
import com.veterinary.veterinaryApp.Repositories.WalkerRepository;
import com.veterinary.veterinaryApp.models.Walker;
import com.veterinary.veterinaryApp.services.WalkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalkerServiceImpl implements WalkerService {

    @Autowired
    WalkerRepository walkerRepository;

    @Override
    public List<Walker> getAllWalkers() {
        return walkerRepository.findAll();
    }

    @Override
    public List<WalkerDTO> getAllWalkersDto(WalkerDTO walkerDTO) {
        return walkerRepository.findAll().stream().map(WalkerDTO::new).collect(Collectors.toList());
    }

    @Override
    public Walker getWalkerById(Long id) {
        return null;
    }

    @Override
    public void saveWalker(Walker walker) {
        walkerRepository.save(walker);
    }
}
