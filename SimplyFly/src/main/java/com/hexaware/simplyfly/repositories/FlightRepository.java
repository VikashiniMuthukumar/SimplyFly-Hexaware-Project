package com.hexaware.simplyfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.simplyfly.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
