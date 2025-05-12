package com.github.sergiooliveirabr.myhome.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CleaningItemDoneId implements Serializable {

    private Long cleaning;
    private Long cleaningItem;

    public CleaningItemDoneId() {}

    public CleaningItemDoneId(Long cleaningItem, Long cleaning) {
        this.cleaningItem = cleaningItem;
        this.cleaning = cleaning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CleaningItemDoneId that = (CleaningItemDoneId) o;
        return Objects.equals(cleaning, that.cleaning) && Objects.equals(cleaningItem, that.cleaningItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cleaningItem, cleaning);
    }
}
