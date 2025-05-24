package com.hexaware.simplyfly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.dto.FlightDTO;
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
	
	@Override
	public Flight addFlight(FlightDTO flightDTO) {
		Flight flight = new Flight();
		flight.setName(flightDTO.getName());
		flight.setFlightCode(flightDTO.getFlightCode());
		flight.setTotalSeats(flightDTO.getTotalSeats());
		flight.setCabinBaggageLimit(flightDTO.getCabinBaggageLimit());
		flight.setCheckInBaggageLimit(flightDTO.getCheckInBaggageLimit());

		return flightrepo.save(flight);
	}

	@Override
	public int updateCabinBaggageLimit(int newLimit, Long flightId) {
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
