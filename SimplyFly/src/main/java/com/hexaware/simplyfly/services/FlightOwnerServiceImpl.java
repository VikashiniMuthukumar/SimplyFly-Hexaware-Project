package com.hexaware.simplyfly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.entities.Flight;
import com.hexaware.simplyfly.entities.FlightOwner;
import com.hexaware.simplyfly.repositories.FlightOwnerRepository;

@Service
public class FlightOwnerServiceImpl implements IFlightOwnerService{

	@Autowired
	FlightOwnerRepository repo;
	
	@Override
	public FlightOwner getOwnerById(Long ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlightOwner assignFlightOwnerRole(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> getAllFlightsByOwner(Long ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
