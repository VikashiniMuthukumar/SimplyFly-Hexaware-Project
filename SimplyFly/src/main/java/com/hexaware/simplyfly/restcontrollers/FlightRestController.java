package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import com.hexaware.simplyfly.dto.FlightDTO;
import com.hexaware.simplyfly.entities.Flight;
import com.hexaware.simplyfly.exceptions.FlightNotFoundException;
import com.hexaware.simplyfly.exceptions.FlightOwnerNotFoundException;
import com.hexaware.simplyfly.services.IFlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flights")
public class FlightRestController {

    @Autowired
    private IFlightService flightService;

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody FlightDTO dto) throws FlightOwnerNotFoundException {
        Flight flight = flightService.createFlight(dto);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long flightId, @RequestBody FlightDTO dto) throws FlightNotFoundException, FlightOwnerNotFoundException {
        Flight flight = flightService.updateFlight(flightId, dto);
        return ResponseEntity.ok(flight);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId) throws FlightNotFoundException {
        flightService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long flightId) throws FlightNotFoundException {
        Flight flight = flightService.getFlightById(flightId);
        return ResponseEntity.ok(flight);
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }
}
