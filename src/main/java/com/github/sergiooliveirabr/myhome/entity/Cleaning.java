package com.github.sergiooliveirabr.myhome.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Cleaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person responsiblePerson;

    private LocalDate dataHeld;

    @OneToMany(mappedBy = "cleaning", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CleaningItemDone> itemsDoneList;

    public void addItemDone(CleaningItem item) {

        CleaningItemDone cleaningItemDone = new CleaningItemDone();

        cleaningItemDone.setCleaning(this);
        cleaningItemDone.setCleaningItem(item);
        this.itemsDoneList.add(cleaningItemDone);
    }

    public void removeItemDone(CleaningItem item) {
        this.itemsDoneList.removeIf(itemDone -> itemDone.getCleaningItem().equals(item));
    }
}
