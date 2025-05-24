package com.hexaware.simplyfly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.entities.Flight;
import com.hexaware.simplyfly.entities.FlightOwner;
import com.hexaware.simplyfly.repositories.FlightOwnerRepository;
import com.hexaware.simplyfly.repositories.FlightRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class FlightServiceImpl implements IFlightService {

	@Autowired
	FlightRepository flightrepo;

	@Autowired
	FlightOwnerRepository flightOwnerRepo;

	@Override
	public Flight addFlight(Long ownerId, Flight flight) {
		return flightrepo.save(flight);
	}

	@Override
	public int updateCabinBaggageLimit( int newLimit,Long flightId) {
		return flightrepo.updateCabinBaggageLimit(newLimit, flightId);
	}

	@Override
	public Flight getFlightById(Long flightId) {
		return flightrepo.findById(flightId).orElse(null);
	}

	@Override
	public List<Flight> getAllFlights() {
		return flightrepo.findAll();
	}

	@Override
	public void deleteFlight(Long flightId) {
		flightrepo.deleteById(flightId);
	}
}
