package com.hexaware.simplyfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.entities.Cancellation;
import com.hexaware.simplyfly.repositories.CancellationRepository;

@Service
public class CancellationServiceImpl implements ICancellationService{

	@Autowired
	CancellationRepository repo;
	
	@Override
	public Cancellation cancelBooking(Long bookingId, String reason) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cancellation getCancellationDetails(Long cancellationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
