package com.github.sergiooliveirabr.myhome.service.schedule;

import com.github.sergiooliveirabr.myhome.entity.cleaning.Room;
import com.github.sergiooliveirabr.myhome.entity.schedule.CleaningSchedule;
import com.github.sergiooliveirabr.myhome.repository.CleaningScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ScheduleService {

    private final CleaningScheduleRepository cleaningScheduleRepository;

    @Autowired
    public ScheduleService(CleaningScheduleRepository cleaningScheduleRepository) {
        this.cleaningScheduleRepository = cleaningScheduleRepository;
    }

    public void initializeSchedule(Room startingRoom) {

        cleaningScheduleRepository.deleteAll();

        Room[] availableRooms = Room.values();
        int startIndex = Arrays.asList(availableRooms).indexOf(startingRoom);

        for (int i = 0; i < 6; i++) {
            Room scheduleRoom = availableRooms[(startIndex + i) % availableRooms.length];
            CleaningSchedule cleaningSchedule = new CleaningSchedule();
            cleaningSchedule.setRoom(scheduleRoom);
            cleaningSchedule.setCompleted(false);
            cleaningScheduleRepository.save(cleaningSchedule);
        }
    }

    public List<CleaningSchedule> getCurrentSchedule() {
        return cleaningScheduleRepository.findByCompletedFalse();
    }

}
