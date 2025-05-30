package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import com.hexaware.simplyfly.dto.BookingDTO;
import com.hexaware.simplyfly.entities.Booking;
import com.hexaware.simplyfly.exceptions.*;

import com.hexaware.simplyfly.services.IBookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingRestController {

    @Autowired
    private IBookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO dto) throws UserNotFoundException, RouteNotFoundException, PaymentNotFoundException, CancellationNotFoundException {
        Booking booking = bookingService.createBooking(dto);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @RequestBody BookingDTO dto) throws BookingNotFoundException, UserNotFoundException, RouteNotFoundException, PaymentNotFoundException, CancellationNotFoundException {
        Booking booking = bookingService.updateBooking(bookingId, dto);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) throws BookingNotFoundException {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) throws BookingNotFoundException {
        Booking booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
}
