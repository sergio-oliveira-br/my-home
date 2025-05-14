package com.github.sergiooliveirabr.myhome.repository;

import com.github.sergiooliveirabr.myhome.entity.cleaning.Cleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningRepository extends JpaRepository<Cleaning, Long> {
}
