package com.hexaware.simplyfly.services;

import java.util.List;

import com.hexaware.simplyfly.entities.Booking;

public interface IBookingService {

	Booking bookFlight(Long userId, Long routeId, List<Long> seatIds);
	Booking getBookingById(Long bookingId);
	List<Booking> getBookingsByUserId(Long userId);
	Booking cancelBooking(Long bookingId, String reason);
}
