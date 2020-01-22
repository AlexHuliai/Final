package com.running.controller;

import com.running.entity.Event;
import com.running.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;
    @RequestMapping(value="/submitEventDetails", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void submitUserDetails(@RequestBody Event event) {

        this.eventRepository.save(event);
    }
}
