package com.github.sergiooliveirabr.myhome.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Room assignedRoom;
}
