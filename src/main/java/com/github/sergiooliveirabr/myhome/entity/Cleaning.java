package com.github.sergiooliveirabr.myhome.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Cleaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "responsible_person_id")
    private Person responsiblePerson;

    @ManyToOne
    @JoinColumn(name = "responsible_room_id")
    private Room responsibleRoom;

    private LocalDate dataHeld;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(Person responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Room getResponsibleRoom() {
        return responsibleRoom;
    }

    public void setResponsibleRoom(Room responsibleRoom) {
        this.responsibleRoom = responsibleRoom;
    }

    public LocalDate getDataHeld() {
        return dataHeld;
    }

    public void setDataHeld(LocalDate dataHeld) {
        this.dataHeld = dataHeld;
    }
}
