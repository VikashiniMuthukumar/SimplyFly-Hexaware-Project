package com.hexaware.simplyfly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.entities.Flight;
import com.hexaware.simplyfly.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements IFlightService{

	@Autowired
	FlightRepository repo;
	
	@Override
	public Flight addFlight(Long ownerId, Flight flight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight updateFlight(Long flightId, Flight flight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight getFlightById(Long flightId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> getAllFlights() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFlight(Long flightId) {
		// TODO Auto-generated method stub
		
	}

}
