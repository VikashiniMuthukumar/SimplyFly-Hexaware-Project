package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import com.hexaware.simplyfly.dto.PaymentsDTO;
import com.hexaware.simplyfly.entities.Payments;
import com.hexaware.simplyfly.exceptions.PaymentNotFoundException;
import com.hexaware.simplyfly.services.IPaymentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentsRestController {

    @Autowired
    private IPaymentsService paymentsService;

    @PostMapping
    public ResponseEntity<Payments> createPayment(@RequestBody PaymentsDTO dto) {
        Payments payment = paymentsService.createPayment(dto);
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<Payments> updatePayment(@PathVariable Long paymentId, @RequestBody PaymentsDTO dto) throws PaymentNotFoundException {
        Payments payment = paymentsService.updatePayment(paymentId, dto);
        return ResponseEntity.ok(payment);
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) throws PaymentNotFoundException {
        paymentsService.deletePayment(paymentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable Long paymentId) throws PaymentNotFoundException {
        Payments payment = paymentsService.getPaymentById(paymentId);
        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public ResponseEntity<List<Payments>> getAllPayments() {
        return ResponseEntity.ok(paymentsService.getAllPayments());
    }
}
