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

import com.hexaware.simplyfly.dto.AdminDTO;
import com.hexaware.simplyfly.dto.FlightDTO;
import com.hexaware.simplyfly.dto.UserDTO;
import com.hexaware.simplyfly.entities.Admin;
import com.hexaware.simplyfly.entities.Flight;
import com.hexaware.simplyfly.entities.User;
import com.hexaware.simplyfly.exceptions.AdminNotFoundException;
import com.hexaware.simplyfly.exceptions.UserNotFoundException;
import com.hexaware.simplyfly.services.IAdminService;

import jakarta.validation.Valid;  // or javax.validation.Valid based on your setup
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/admins")
public class AdminRestController {

    @Autowired
    private IAdminService adminService;

    // Admin endpoints

    @PostMapping
    public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody AdminDTO adminDTO) throws UserNotFoundException {
        log.info("Registering new admin: {}", adminDTO);
        Admin admin = adminService.registerAdmin(adminDTO);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long adminId, @Valid @RequestBody AdminDTO adminDTO)
            throws AdminNotFoundException, UserNotFoundException {
        log.info("Updating admin with ID: {}", adminId);
        Admin updated = adminService.updateAdmin(adminId, adminDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long adminId) throws AdminNotFoundException {
        log.warn("Deleting admin with ID: {}", adminId);
        adminService.deleteAdmin(adminId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long adminId) throws AdminNotFoundException {
        log.info("Fetching admin with ID: {}", adminId);
        Admin admin = adminService.getAdminById(adminId);
        return ResponseEntity.ok(admin);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        log.info("Fetching all admins");
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    // User endpoints

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody UserDTO userDTO) {
        log.info("Adding new user: {}", userDTO);
        User user = adminService.addUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @Valid @RequestBody UserDTO userDTO)
            throws UserNotFoundException {
        log.info("Updating user with ID: {}", userId);
        User user = adminService.updateUser(userId, userDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) throws UserNotFoundException {
        log.warn("Deleting user with ID: {}", userId);
        adminService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) throws UserNotFoundException {
        log.info("Fetching user with ID: {}", userId);
        User user = adminService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        log.info("Fetching all users");
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    // Flight endpoints

    @PostMapping("/flights")
    public ResponseEntity<Flight> addFlight(@Valid @RequestBody FlightDTO flightDTO) {
        log.info("Adding new flight: {}", flightDTO);
        Flight flight = adminService.addFlight(flightDTO);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @PutMapping("/flights/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long flightId, @Valid @RequestBody FlightDTO flightDTO) {
        log.info("Updating flight with ID: {}", flightId);
        Flight flight = adminService.updateFlight(flightId, flightDTO);
        return ResponseEntity.ok(flight);
    }

    @DeleteMapping("/flights/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId) {
        log.warn("Deleting flight with ID: {}", flightId);
        adminService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        log.info("Fetching all flights");
        return ResponseEntity.ok(adminService.getAllFlights());
    }

    @GetMapping("/flights/{flightId}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long flightId) {
        log.info("Fetching flight with ID: {}", flightId);
        Flight flight = adminService.getFlightById(flightId);
        return ResponseEntity.ok(flight);
    }
}
