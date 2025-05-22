package com.github.sergiooliveirabr.myhome.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Cleaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person responsiblePerson;

    private LocalDate dataHeld;
}
