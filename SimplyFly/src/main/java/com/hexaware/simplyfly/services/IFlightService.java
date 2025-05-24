package com.hexaware.simplyfly.services;

import java.util.List;

import com.hexaware.simplyfly.entities.Flight;

public interface IFlightService {

	Flight addFlight(Long ownerId, Flight flight);
    Flight updateFlight(Long flightId, Flight flight);
    Flight getFlightById(Long flightId);
    List<Flight> getAllFlights();
    void deleteFlight(Long flightId);
}
