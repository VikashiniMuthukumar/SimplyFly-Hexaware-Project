package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.simplyfly.dto.PaymentsDTO;
import com.hexaware.simplyfly.entities.Payments;
import com.hexaware.simplyfly.exceptions.PaymentNotFoundException;
import com.hexaware.simplyfly.services.IPaymentsService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/payments")
public class PaymentsRestController {

    @Autowired
    private IPaymentsService paymentsService;

    @PostMapping
    public ResponseEntity<String> createPayment(@Valid @RequestBody PaymentsDTO dto) {
        log.info("Creating Payment with data: {}", dto);
        Payments payment = paymentsService.createPayment(dto);
        log.info("Payment created with ID: {}", payment.getPayment_id());
        return new ResponseEntity<>("Payment created successfully with ID: " + payment.getPayment_id(), HttpStatus.CREATED);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<String> updatePayment(@PathVariable Long paymentId, @Valid @RequestBody PaymentsDTO dto) throws PaymentNotFoundException {
        log.info("Updating Payment with ID: {}", paymentId);
        Payments payment = paymentsService.updatePayment(paymentId, dto);
        log.info("Payment updated: {}", payment);
        return ResponseEntity.ok("Payment updated successfully for ID: " + payment.getPayment_id());
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<String> deletePayment(@PathVariable Long paymentId) throws PaymentNotFoundException {
        log.warn("Deleting Payment with ID: {}", paymentId);
        paymentsService.deletePayment(paymentId);
        log.info("Payment deleted with ID: {}", paymentId);
        return ResponseEntity.ok("Payment deleted successfully for ID: " + paymentId);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable Long paymentId) throws PaymentNotFoundException {
        log.info("Fetching Payment with ID: {}", paymentId);
        Payments payment = paymentsService.getPaymentById(paymentId);
        log.info("Payment fetched: {}", payment);
        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public ResponseEntity<List<Payments>> getAllPayments() {
        log.info("Fetching all Payments");
        List<Payments> payments = paymentsService.getAllPayments();
        log.info("Total Payments fetched: {}", payments.size());
        return ResponseEntity.ok(payments);
    }
}
