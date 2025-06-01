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

import com.hexaware.simplyfly.dto.BookingDTO;
import com.hexaware.simplyfly.entities.Booking;
import com.hexaware.simplyfly.exceptions.BookingNotFoundException;
import com.hexaware.simplyfly.exceptions.CancellationNotFoundException;
import com.hexaware.simplyfly.exceptions.PaymentNotFoundException;
import com.hexaware.simplyfly.exceptions.RouteNotFoundException;
import com.hexaware.simplyfly.exceptions.UserNotFoundException;
import com.hexaware.simplyfly.services.IBookingService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/bookings")
public class BookingRestController {

    @Autowired
    private IBookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@Valid @RequestBody BookingDTO dto) throws UserNotFoundException, RouteNotFoundException, PaymentNotFoundException, CancellationNotFoundException {
        log.info("Creating booking with data: {}", dto);
        Booking booking = bookingService.createBooking(dto);
        log.info("Booking created with ID: {}", booking.getBooking_id());
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @Valid @RequestBody BookingDTO dto) throws BookingNotFoundException, UserNotFoundException, RouteNotFoundException, PaymentNotFoundException, CancellationNotFoundException {
        log.info("Updating booking with ID: {}", bookingId);
        Booking booking = bookingService.updateBooking(bookingId, dto);
        log.info("Booking updated: {}", booking);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) throws BookingNotFoundException {
        log.warn("Deleting booking with ID: {}", bookingId);
        bookingService.deleteBooking(bookingId);
        log.info("Booking deleted with ID: {}", bookingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) throws BookingNotFoundException {
        log.info("Fetching booking with ID: {}", bookingId);
        Booking booking = bookingService.getBookingById(bookingId);
        log.info("Booking fetched: {}", booking);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        log.info("Fetching all bookings");
        List<Booking> bookings = bookingService.getAllBookings();
        log.info("Total bookings fetched: {}", bookings.size());
        return ResponseEntity.ok(bookings);
    }
}
