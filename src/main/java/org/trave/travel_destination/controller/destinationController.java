package org.trave.travel_destination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.trave.travel_destination.dto.destination;
import org.trave.travel_destination.service.destinationService;

@RestController
public class destinationController {

    @Autowired
    destinationService service;

    // To Add New Destination
    @PostMapping("/destinations")
    public ResponseEntity<Object> addDestination(@RequestBody destination destination){
        return service.addDestination(destination);
    }
    
}
