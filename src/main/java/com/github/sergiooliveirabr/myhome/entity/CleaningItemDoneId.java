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

    private Long cleaningItemId;
    private Long cleaningId;

    public CleaningItemDoneId() {}

    public CleaningItemDoneId(Long cleaningItemId, Long cleaningId) {
        this.cleaningItemId = cleaningItemId;
        this.cleaningId = cleaningId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CleaningItemDoneId that = (CleaningItemDoneId) o;
        return Objects.equals(cleaningId, that.cleaningId) && Objects.equals(cleaningItemId, that.cleaningItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cleaningItemId, cleaningId);
    }
}
