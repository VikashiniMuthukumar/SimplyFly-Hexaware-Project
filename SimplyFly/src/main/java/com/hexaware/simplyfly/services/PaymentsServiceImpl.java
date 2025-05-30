package com.hexaware.simplyfly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.dto.PaymentsDTO;
import com.hexaware.simplyfly.entities.Booking;
import com.hexaware.simplyfly.entities.Payments;
import com.hexaware.simplyfly.exceptions.PaymentNotFoundException;
import com.hexaware.simplyfly.repositories.BookingRepository;
import com.hexaware.simplyfly.repositories.PaymentsRepository;

@Service
public class PaymentsServiceImpl implements IPaymentsService {

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Payments createPayment(PaymentsDTO dto) {
        Booking booking = bookingRepository.findById(dto.getBooking_id()).orElse(null);
        Payments payment = new Payments();
        payment.setAmount(dto.getAmount());
        payment.setMethod(dto.getMethod());
        payment.setPaymentStatus(dto.getPaymentStatus());
        payment.setPaidAt(dto.getPaidAt() != null ? dto.getPaidAt() : payment.getPaidAt());
        payment.setBooking(booking);
        return paymentsRepository.save(payment);
    }

    @Override
    public Payments updatePayment(Long paymentId, PaymentsDTO dto) throws PaymentNotFoundException {
        Payments payment = paymentsRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with ID: " + paymentId));
        Booking booking = bookingRepository.findById(dto.getBooking_id()).orElse(null);
        payment.setAmount(dto.getAmount());
        payment.setMethod(dto.getMethod());
        payment.setPaymentStatus(dto.getPaymentStatus());
        payment.setPaidAt(dto.getPaidAt() != null ? dto.getPaidAt() : payment.getPaidAt());
        payment.setBooking(booking);
        return paymentsRepository.save(payment);
    }

    @Override
    public boolean deletePayment(Long paymentId) throws PaymentNotFoundException {
        if (!paymentsRepository.existsById(paymentId)) {
            throw new PaymentNotFoundException("Payment not found with ID: " + paymentId);
        }
        paymentsRepository.deleteById(paymentId);
        return true;
    }

    @Override
    public Payments getPaymentById(Long paymentId) throws PaymentNotFoundException {
        return paymentsRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with ID: " + paymentId));
    }

    @Override
    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
    }
}
