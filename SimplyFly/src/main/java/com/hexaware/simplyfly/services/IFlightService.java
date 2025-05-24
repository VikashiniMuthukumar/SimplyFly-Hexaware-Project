package com.hexaware.simplyfly.services;

import java.util.List;

import com.hexaware.simplyfly.dto.FlightDTO;
import com.hexaware.simplyfly.entities.Flight;

public interface IFlightService {

	Flight addFlight(FlightDTO flightDTO);
	int updateCabinBaggageLimit(int newLimit, Long flightId);
    Flight getFlightById(Long flightId);
    List<Flight> getAllFlights();
    void deleteFlight(Long flightId);
}
