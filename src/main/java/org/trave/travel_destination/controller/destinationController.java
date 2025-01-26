package org.trave.travel_destination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.trave.travel_destination.service.destinationService;

@RestController
public class destinationController {

    @Autowired
    destinationService service;
    
}
