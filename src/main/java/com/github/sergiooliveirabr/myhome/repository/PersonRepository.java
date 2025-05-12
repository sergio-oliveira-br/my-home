package com.github.sergiooliveirabr.myhome.repository;

import com.github.sergiooliveirabr.myhome.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
