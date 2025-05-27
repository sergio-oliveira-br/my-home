package com.github.sergiooliveirabr.myhome.service;

import com.github.sergiooliveirabr.myhome.entity.Cleaning;
import com.github.sergiooliveirabr.myhome.repository.CleaningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PastCleaningService {

    private final CleaningRepository cleaningRepository;

    @Autowired
    public PastCleaningService(CleaningRepository cleaningRepository) {
        this.cleaningRepository = cleaningRepository;
    }

    public List<Cleaning> findAll() {
        return cleaningRepository.findAll();
    }

    public Optional<Cleaning> findLastCleaning() {
        return cleaningRepository.findTopByOrderByIdDesc();
    }
}
