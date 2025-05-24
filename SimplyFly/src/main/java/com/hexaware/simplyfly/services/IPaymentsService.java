package com.hexaware.simplyfly.services;

import com.hexaware.simplyfly.entities.Payments;

public interface IPaymentsService {

	Payments makePayment(Long bookingId, Payments payment);
    Payments getPaymentById(Long paymentId);
}
