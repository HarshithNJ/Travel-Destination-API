package org.trave.travel_destination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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






    // To Fetch Destinations Data
    //To Get All Destinations
    @GetMapping("/destinations")
    public ResponseEntity<Object> getDestinations(){
        return service.getDestinations();
    }
    
    //To Get Destination by Country Name
    @GetMapping("/destinations/{country}")
    public ResponseEntity<Object> getDestByCountry(@PathVariable String country){
        return service.getDestByCountry(country);
    }

    //To Get Destination by Name
    @GetMapping("/destinations/name/{name}")
    public ResponseEntity<Object> getDestByName(@PathVariable String name){
        return service.getDestByName(name);
    }





    // To Delete a Destination Data
    @DeleteMapping("/destinations/{name}")
    public ResponseEntity<Object> deleteDest(@PathVariable String name){
        return service.deleteDest(name);
    }






    // To Update a Destination Data
    @PatchMapping("/destinations/{id}")
    public ResponseEntity<Object> updateDestination(@PathVariable int id, @RequestBody destination destination){
        return service.updateDestination(id, destination);
    }

}
