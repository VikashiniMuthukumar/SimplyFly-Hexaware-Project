package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import com.hexaware.simplyfly.dto.AdminDTO;
import com.hexaware.simplyfly.dto.FlightDTO;
import com.hexaware.simplyfly.dto.UserDTO;
import com.hexaware.simplyfly.entities.Admin;
import com.hexaware.simplyfly.entities.Flight;
import com.hexaware.simplyfly.entities.User;
import com.hexaware.simplyfly.exceptions.AdminNotFoundException;
import com.hexaware.simplyfly.exceptions.UserNotFoundException;
import com.hexaware.simplyfly.services.IAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminRestController {

    @Autowired
    private IAdminService adminService;

    // Admin endpoints
    @PostMapping
    public ResponseEntity<Admin> registerAdmin(@RequestBody AdminDTO adminDTO) throws UserNotFoundException {
        Admin admin = adminService.registerAdmin(adminDTO);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long adminId, @RequestBody AdminDTO adminDTO) throws AdminNotFoundException, UserNotFoundException {
        Admin updated = adminService.updateAdmin(adminId, adminDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long adminId) throws AdminNotFoundException {
        adminService.deleteAdmin(adminId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long adminId) throws AdminNotFoundException {
        Admin admin = adminService.getAdminById(adminId);
        return ResponseEntity.ok(admin);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    // User endpoints (delegated)
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
        User user = adminService.addUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) throws UserNotFoundException {
        User user = adminService.updateUser(userId, userDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) throws UserNotFoundException {
        adminService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) throws UserNotFoundException {
        User user = adminService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    // Flight endpoints (delegated)
    @PostMapping("/flights")
    public ResponseEntity<Flight> addFlight(@RequestBody FlightDTO flightDTO) {
        Flight flight = adminService.addFlight(flightDTO);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @PutMapping("/flights/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long flightId, @RequestBody FlightDTO flightDTO) {
        Flight flight = adminService.updateFlight(flightId, flightDTO);
        return ResponseEntity.ok(flight);
    }

    @DeleteMapping("/flights/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId) {
        adminService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(adminService.getAllFlights());
    }

    @GetMapping("/flights/{flightId}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long flightId) {
        Flight flight = adminService.getFlightById(flightId);
        return ResponseEntity.ok(flight);
    }
}
