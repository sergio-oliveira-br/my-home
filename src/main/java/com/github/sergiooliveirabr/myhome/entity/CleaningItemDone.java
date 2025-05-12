package com.github.sergiooliveirabr.myhome.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@IdClass(CleaningItemDoneId.class)
public class CleaningItemDone {

    @Id
    @ManyToOne
    @JoinColumn(name = "cleaning_id")
    private Cleaning cleaning;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_cleaning_id")
    private CleaningItem cleaningItem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CleaningItemDone that = (CleaningItemDone) o;
        return Objects.equals(cleaning, that.cleaning) && Objects.equals(cleaningItem, that.cleaningItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cleaning, cleaningItem);
    }
}
