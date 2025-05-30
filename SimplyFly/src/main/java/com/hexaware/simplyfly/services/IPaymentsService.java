package com.hexaware.simplyfly.services;

import java.util.List;

import com.hexaware.simplyfly.dto.PaymentsDTO;
import com.hexaware.simplyfly.entities.Payments;
import com.hexaware.simplyfly.exceptions.PaymentNotFoundException;

public interface IPaymentsService {
    Payments createPayment(PaymentsDTO dto);
    Payments updatePayment(Long paymentId, PaymentsDTO dto) throws PaymentNotFoundException;
    boolean deletePayment(Long paymentId) throws PaymentNotFoundException;
    Payments getPaymentById(Long paymentId) throws PaymentNotFoundException;
    List<Payments> getAllPayments();
}
