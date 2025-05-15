package com.github.sergiooliveirabr.myhome.repository;

import com.github.sergiooliveirabr.myhome.entity.schedule.CleaningSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleaningScheduleRepository extends JpaRepository<CleaningSchedule, Long> {
}
