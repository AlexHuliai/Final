package com.capston.caps.repository;

import com.capston.caps.model.Event;

import com.capston.caps.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("FROM Event WHERE street=?1 ")
    List<Event> findByStreet(String street);

}
