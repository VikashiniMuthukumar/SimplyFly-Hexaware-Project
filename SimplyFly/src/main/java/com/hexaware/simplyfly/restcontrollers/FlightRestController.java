package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.simplyfly.dto.FlightDTO;
import com.hexaware.simplyfly.entities.Flight;
import com.hexaware.simplyfly.exceptions.FlightNotFoundException;
import com.hexaware.simplyfly.exceptions.FlightOwnerNotFoundException;
import com.hexaware.simplyfly.services.IFlightService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/flights")
public class FlightRestController {

    @Autowired
    private IFlightService flightService;

    @PostMapping
    public ResponseEntity<Flight> createFlight(@Valid @RequestBody FlightDTO dto) throws FlightOwnerNotFoundException {
        log.info("Creating Flight with data: {}", dto);
        Flight flight = flightService.createFlight(dto);
        log.info("Flight created with ID: {}", flight.getFlight_id());
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long flightId, @Valid @RequestBody FlightDTO dto) throws FlightNotFoundException, FlightOwnerNotFoundException {
        log.info("Updating Flight with ID: {}", flightId);
        Flight flight = flightService.updateFlight(flightId, dto);
        log.info("Flight updated: {}", flight);
        return ResponseEntity.ok(flight);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId) throws FlightNotFoundException {
        log.warn("Deleting Flight with ID: {}", flightId);
        flightService.deleteFlight(flightId);
        log.info("Flight deleted with ID: {}", flightId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long flightId) throws FlightNotFoundException {
        log.info("Fetching Flight with ID: {}", flightId);
        Flight flight = flightService.getFlightById(flightId);
        log.info("Flight fetched: {}", flight);
        return ResponseEntity.ok(flight);
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        log.info("Fetching all Flights");
        List<Flight> flights = flightService.getAllFlights();
        log.info("Total Flights fetched: {}", flights.size());
        return ResponseEntity.ok(flights);
    }
}
