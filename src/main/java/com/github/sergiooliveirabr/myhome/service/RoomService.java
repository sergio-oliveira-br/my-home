package com.github.sergiooliveirabr.myhome.service;

import com.github.sergiooliveirabr.myhome.entity.Cleaning;
import com.github.sergiooliveirabr.myhome.entity.Room;
import com.github.sergiooliveirabr.myhome.repository.CleaningRepository;
import com.github.sergiooliveirabr.myhome.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final CleaningRepository cleaningRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, CleaningRepository cleaningRepository) {
        this.roomRepository = roomRepository;
        this.cleaningRepository = cleaningRepository;
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room getNextRoomInRotation() {

        // Find the rooms
        List<Room> allRooms = roomRepository.findAllByOrderByIdAsc();
        if (allRooms.isEmpty()) {
           throw new IllegalArgumentException("There is no next room");
        }

        // Find the last room that has done the cleaning
        Optional<Cleaning> lastCleaning = cleaningRepository.findTopByOrderByIdDesc();
        if (lastCleaning.isEmpty()) {
            return allRooms.getFirst();
        }

        Room lastRoom = lastCleaning.get().getResponsiblePerson().getRoom();

        int indexRoom = allRooms.indexOf(lastRoom);

        int nextIndex = (indexRoom + 1) % allRooms.size();

        return allRooms.get(nextIndex);
    }
}
