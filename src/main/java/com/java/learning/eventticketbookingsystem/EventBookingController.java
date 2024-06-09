package com.java.learning.eventticketbookingsystem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 For any this kind of ticket booking system. There would be 3 main component will be there
 Event, User and Ticket
 first users should be able to see the list of all events and then they can book any of the event
 */

@RestController("/api/v1")
public class EventBookingController {

    /**
     *
     API 1
     The first API should be to fetch the list of all events. This API should return list of Events with all details of events
     * @return
     */
    @GetMapping("/event")
    public List<Event> getAllEvent(){
        return List.of(new Event());
    }

    /**
     *
     API 2
     Second we should create an API to book the event. This API should take the list of users and booking detail in the request
     We can take the event id in the path variable and user details in the request body
     This API should return an object of Ticket which will be having all details of event booking.
     * @param eventId
     * @param users
     * @return
     */
    @PostMapping("/book/{id}")
    public Ticket bookEvent(@PathVariable("id") String eventId, @RequestBody List<User> users){
        return new Ticket();
    }
}


