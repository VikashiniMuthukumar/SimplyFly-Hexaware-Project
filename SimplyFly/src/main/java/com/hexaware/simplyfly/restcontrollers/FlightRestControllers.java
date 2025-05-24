package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.hexaware.simplyfly.services.IFlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightRestControllers {

    @Autowired
    private IFlightService flightService;


    @GetMapping("/getall")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") Long id) {
        Flight flight = flightService.getFlightById(id);
        return (flight != null) ? ResponseEntity.ok(flight) : ResponseEntity.notFound().build();
    }


    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@RequestBody FlightDTO flightDTO) {
        Flight addedFlight = flightService.addFlight(flightDTO);
        if (addedFlight == null) {
            return ResponseEntity.badRequest().build();  // or custom error response
        }
        return ResponseEntity.ok(addedFlight);
    }

    @PutMapping("/updateCabinLimit/{flightId}/{limit}")
    public ResponseEntity<String> updateCabinLimit(@PathVariable Long flightId, @PathVariable int limit) {
        int count = flightService.updateCabinBaggageLimit(limit, flightId);
        if (count > 0) {
            return ResponseEntity.ok("Cabin baggage limit updated successfully.");
        } else {
            return ResponseEntity.status(404).body("Flight with ID " + flightId + " not found.");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.ok("Flight deleted successfully.");
    }
}
