package com.github.sergiooliveirabr.myhome.service;

import com.github.sergiooliveirabr.myhome.entity.Cleaning;
import com.github.sergiooliveirabr.myhome.repository.CleaningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public String getFormattedLastCleaningDetails() {
        Optional<Cleaning> lastCleaningOptional = findLastCleaning();

        String dateDisplay = null;

        if (lastCleaningOptional.isPresent()) {
            Cleaning lastCleaning = lastCleaningOptional.get();

            LocalDate lastCleaningDate = lastCleaning.getDataHeld();
            LocalDate today = LocalDate.now();

            long daysDifference = ChronoUnit.DAYS.between(lastCleaningDate, today);
            String lastDone = "Last Done | ";

            if (daysDifference == 0) {
                dateDisplay = lastDone +  "Today";
            } else if (daysDifference == 1) {
                dateDisplay = lastDone + "Yesterday";
            } else if (daysDifference > 1) {
                dateDisplay = lastDone + daysDifference + " days ago";
            }
        }
        return dateDisplay;
    }
}
