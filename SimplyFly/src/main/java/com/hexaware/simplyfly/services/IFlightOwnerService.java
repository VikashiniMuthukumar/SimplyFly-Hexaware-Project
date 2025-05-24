package com.hexaware.simplyfly.services;

import java.util.List;

import com.hexaware.simplyfly.entities.Flight;
import com.hexaware.simplyfly.entities.FlightOwner;

public interface IFlightOwnerService {

	FlightOwner getOwnerById(Long ownerId);
    FlightOwner assignFlightOwnerRole(Long userId);
    List<Flight> getAllFlightsByOwner(Long ownerId);
}
