package com.capston.caps.service;

import com.capston.caps.model.Event;
import com.capston.caps.model.Users;
import com.capston.caps.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventServiceImpl implements EventService {
@Autowired
   private  EventRepository eventRepository;
    @Override
    public Optional<Event> findById(long id) {
      return eventRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }


    @Override
    public void update(Event event) {
        Event events=findById(event.getId()).get();
    if(events!= null) {
        events.setStreet(event.getStreet());
        events.setState(event.getState());
        events.setZipcode(event.getZipcode());
        events.setTime(event.getTime());
        event.setUser_email(event.getUser_email());
    }

    }



    @Override
    public List<Event> findAll() {
        return null;
    }

    @Override
    public Optional<Event> findByEmail(String email) {
        return Optional.empty();
    }
}
