package com.hexaware.simplyfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.entities.Payments;
import com.hexaware.simplyfly.repositories.PaymentsRepository;

@Service
public class PaymentsServiceImpl implements IPaymentsService{

	@Autowired
	PaymentsRepository repo;
	
	@Override
	public Payments makePayment(Long bookingId, Payments payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payments getPaymentById(Long paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
