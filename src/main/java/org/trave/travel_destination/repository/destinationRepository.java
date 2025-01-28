package org.trave.travel_destination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trave.travel_destination.dto.destination;

public interface destinationRepository extends JpaRepository<destination, Integer> {

    boolean existsByName(String name);

    List<destination> findByCountry(String country);

}
