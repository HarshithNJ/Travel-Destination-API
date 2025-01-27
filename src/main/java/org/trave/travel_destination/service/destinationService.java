package org.trave.travel_destination.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.trave.travel_destination.dto.destination;
import org.trave.travel_destination.repository.destinationRepository;

@Service
public class destinationService {

    @Autowired
    destinationRepository repository;

    public ResponseEntity<Object> addDestination(destination destination) {
        if(repository.existsByName(destination.getName())){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "Destintion to the place" + destination.getName() + " already exits");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
        }else{
            repository.save(destination);

            Map<String, Object> map = new HashMap<String,Object>();
            map.put("success", "Destination added successfully");
            map.put("Travel Plan", destination);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }
    
}
