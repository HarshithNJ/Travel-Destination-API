package org.trave.travel_destination.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
            if(destination.getRating()<0 && destination.getRating()>5){
                Map<String, Object> map = new HashMap<String,Object>();
                map.put("error", "Rating should be between 0 and 5");

                return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
            }else{
                repository.save(destination);
    
                Map<String, Object> map = new HashMap<String,Object>();
                map.put("success", "Destination added successfully");
                map.put("Travel Plan", destination);
    
                return new ResponseEntity<Object>(map, HttpStatus.CREATED);
            }
        }
    }









    public ResponseEntity<Object> getDestinations() {
        List<destination> dest = repository.findAll();

        if(dest.isEmpty()){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No Destinations found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("success", "Destination Data Found");
            map.put("Travel Plan", dest);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getDestByCountry(String country) {
        List<destination> dest = repository.findByCountry(country);

        if(dest.isEmpty()){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No Destinations found with country name " + country);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("success", "Destination Data Found");
            map.put("Travel Plan", dest);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getDestByName(String name) {
        Optional<destination> dest = repository.findByName(name);

        if(dest.isPresent()){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("success", "Destination Data Found");
            map.put("Travel Plan", dest);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }else{
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No Destinations found with name " + name);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }










    public ResponseEntity<Object> deleteDest(String name) {
        Optional<destination> dest = repository.findByName(name);

        if(dest.isPresent()){
            repository.deleteById(dest.get().getId());

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Destination Deleted successfully");

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No Destinations found with name " + name);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }









    public ResponseEntity<Object> updateDestination(int id, destination destination) {
        Optional<destination> dest = repository.findById(id);

        if(dest.isPresent()){
            destination d = dest.get();

            if(destination.getName() != null)
                d.setName(destination.getName());

            if(destination.getCountry() != null)
                d.setCountry(destination.getCountry());

            if(destination.getDescription() != null)
                d.setDescription(destination.getDescription());

            if(destination.getRating() != 0)
                d.setRating(destination.getRating());

            if(destination.getPrice() != 0)
                d.setPrice(destination.getPrice());

            repository.save(d);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Destination Updated successfully");
            map.put("Travel Plan", d);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No Destinations found with id " + id);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }
    
}
