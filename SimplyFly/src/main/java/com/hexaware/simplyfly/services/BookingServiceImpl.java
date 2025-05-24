package com.hexaware.simplyfly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.entities.Booking;
import com.hexaware.simplyfly.repositories.BookingRepository;

@Service
public class BookingServiceImpl implements IBookingService{

	@Autowired
	BookingRepository repo;
	
	@Override
	public Booking bookFlight(Long userId, Long routeId, List<Long> seatIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking getBookingById(Long bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getBookingsByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking cancelBooking(Long bookingId, String reason) {
		// TODO Auto-generated method stub
		return null;
	}

}
