package com.github.sergiooliveirabr.myhome.repository;

import com.github.sergiooliveirabr.myhome.entity.CleaningItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningItemRepository extends JpaRepository<CleaningItem, Long> {
}
