package com.github.sergiooliveirabr.myhome.entity.schedule;

import com.github.sergiooliveirabr.myhome.entity.cleaning.Room;
import com.github.sergiooliveirabr.myhome.entity.person.Person;
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
}
