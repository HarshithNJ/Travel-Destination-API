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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Travel Destination API", description = "API for Managing Travel Destination Information")
public class destinationController {

    @Autowired
    destinationService service;

    // To Add New Destination
    @Operation(summary = "Add New Destination", description = "Adds a new destination to the travel destination list")
    @ApiResponse(responseCode = "201", description = "Destination added successfully")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "406", description = "Destination already exists")
    @PostMapping("/destinations")
    public ResponseEntity<Object> addDestination(@RequestBody destination destination){
        return service.addDestination(destination);
    }






    // To Fetch Destinations Data
    @Operation(summary = "Get All Destinations", description = "Retrieves a list of all destinations")
    @ApiResponse(responseCode = "302", description = "Destinations retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No destinations found")
    @GetMapping("/destinations")
    public ResponseEntity<Object> getDestinations(){
        return service.getDestinations();
    }
    
    @Operation(summary = "Get Destination by Country", description = "Retrieves a list of destinations by country")
    @ApiResponse(responseCode = "302", description = "Destinations retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No destinations found")
    @GetMapping("/destinations/{country}")
    public ResponseEntity<Object> getDestByCountry(@PathVariable String country){
        return service.getDestByCountry(country);
    }

    @Operation(summary = "Get Destination by Name", description = "Retrieves a destination by name")
    @ApiResponse(responseCode = "302", description = "Destination retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Destination not found")
    @GetMapping("/destinations/name/{name}")
    public ResponseEntity<Object> getDestByName(@PathVariable String name){
        return service.getDestByName(name);
    }





    // To Delete a Destination Data
    @Operation(summary = "Delete a Destination", description = "Delete a Destination By Name")
    @ApiResponse(responseCode = "200", description = "Destination deleted successfully")
    @ApiResponse(responseCode = "404", description = "Destination not found")
    @DeleteMapping("/destinations/{name}")
    public ResponseEntity<Object> deleteDest(@PathVariable String name){
        return service.deleteDest(name);
    }






    // To Update a Destination Data
    @Operation(summary = "Update a Destination", description = "Update a Destination By Id")
    @ApiResponse(responseCode = "200", description = "Destination updated successfully")
    @ApiResponse(responseCode = "404", description = "Destination not found")
    @PatchMapping("/destinations/{id}")
    public ResponseEntity<Object> updateDestination(@PathVariable int id, @RequestBody destination destination){
        return service.updateDestination(id, destination);
    }

}
