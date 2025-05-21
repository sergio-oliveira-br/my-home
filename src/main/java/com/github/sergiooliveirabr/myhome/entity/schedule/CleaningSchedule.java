package com.github.sergiooliveirabr.myhome.entity.schedule;

import com.github.sergiooliveirabr.myhome.entity.cleaning.Room;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CleaningSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //ID for unique identification of each task

    private LocalDateTime cleaningDate; //week day

    @Enumerated(EnumType.STRING)
    private Room room;

    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCleaningDate() {
        return cleaningDate;
    }

    public void setCleaningDate(LocalDateTime cleaningDate) {
        this.cleaningDate = cleaningDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
