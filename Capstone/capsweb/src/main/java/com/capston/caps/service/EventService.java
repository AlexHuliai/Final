package com.capston.caps.service;

import com.capston.caps.model.Event;
import com.capston.caps.model.Users;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Optional<Event> findById(long id);
    void delete(long id);
    void save(Event event);
    void update(Event event);

    List<Event> findAll();
    Optional<Event> findByEmail(String email);

}
