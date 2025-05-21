package com.github.sergiooliveirabr.myhome.repository;

import com.github.sergiooliveirabr.myhome.entity.schedule.CleaningSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CleaningScheduleRepository extends JpaRepository<CleaningSchedule, Long> {

    List<CleaningSchedule> findByCompletedFalse();
}
