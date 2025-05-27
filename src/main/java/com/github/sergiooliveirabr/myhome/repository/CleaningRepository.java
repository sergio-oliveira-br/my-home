package com.github.sergiooliveirabr.myhome.repository;

import com.github.sergiooliveirabr.myhome.entity.Cleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CleaningRepository extends JpaRepository<Cleaning, Long> {
    Optional<Cleaning> findTopByOrderByIdDesc();
}
