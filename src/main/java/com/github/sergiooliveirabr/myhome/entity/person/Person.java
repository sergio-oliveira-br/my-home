package com.github.sergiooliveirabr.myhome.entity.person;

import com.github.sergiooliveirabr.myhome.entity.cleaning.Room;
import jakarta.persistence.*;

@Entity
//@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Room assignedRoom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getAssignedRoom() {
        return assignedRoom;
    }

    public void setAssignedRoom(Room assignedRoom) {
        this.assignedRoom = assignedRoom;
    }
}
