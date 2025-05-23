package com.github.sergiooliveirabr.myhome.service;

import com.github.sergiooliveirabr.myhome.entity.Cleaning;
import com.github.sergiooliveirabr.myhome.repository.CleaningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewCleaningService {

    private final CleaningRepository cleaningRepository;

    @Autowired
    public NewCleaningService(CleaningRepository cleaningRepository) {
        this.cleaningRepository = cleaningRepository;
    }

    public Cleaning save(Cleaning cleaning) {
        return cleaningRepository.save(cleaning);
    }
}
