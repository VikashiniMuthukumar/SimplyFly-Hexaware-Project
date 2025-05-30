package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import com.hexaware.simplyfly.dto.FlightOwnerDTO;
import com.hexaware.simplyfly.entities.FlightOwner;
import com.hexaware.simplyfly.exceptions.FlightOwnerNotFoundException;
import com.hexaware.simplyfly.exceptions.UserNotFoundException;
import com.hexaware.simplyfly.services.IFlightOwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flightowners")
public class FlightOwnerRestController {

    @Autowired
    private IFlightOwnerService flightOwnerService;

    @PostMapping
    public ResponseEntity<FlightOwner> createFlightOwner(@RequestBody FlightOwnerDTO dto) throws UserNotFoundException {
        FlightOwner owner = flightOwnerService.createFlightOwner(dto);
        return new ResponseEntity<>(owner, HttpStatus.CREATED);
    }

    @PutMapping("/{ownerId}")
    public ResponseEntity<FlightOwner> updateFlightOwner(@PathVariable Long ownerId, @RequestBody FlightOwnerDTO dto) throws FlightOwnerNotFoundException, UserNotFoundException {
        FlightOwner owner = flightOwnerService.updateFlightOwner(ownerId, dto);
        return ResponseEntity.ok(owner);
    }

    @DeleteMapping("/{ownerId}")
    public ResponseEntity<Void> deleteFlightOwner(@PathVariable Long ownerId) throws FlightOwnerNotFoundException {
        flightOwnerService.deleteFlightOwner(ownerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<FlightOwner> getFlightOwnerById(@PathVariable Long ownerId) throws FlightOwnerNotFoundException {
        FlightOwner owner = flightOwnerService.getFlightOwnerById(ownerId);
        return ResponseEntity.ok(owner);
    }

    @GetMapping
    public ResponseEntity<List<FlightOwner>> getAllFlightOwners() {
        return ResponseEntity.ok(flightOwnerService.getAllFlightOwners());
    }
}
