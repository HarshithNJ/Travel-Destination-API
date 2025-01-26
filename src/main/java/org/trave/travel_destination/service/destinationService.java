package org.trave.travel_destination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trave.travel_destination.repository.destinationRepository;

@Service
public class destinationService {

    @Autowired
    destinationRepository repository;
    
}
