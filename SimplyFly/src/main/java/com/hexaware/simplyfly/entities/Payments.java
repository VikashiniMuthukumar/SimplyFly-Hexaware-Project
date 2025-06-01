package com.hexaware.simplyfly.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hexaware.simplyfly.enums.PaymentMethod;
import com.hexaware.simplyfly.enums.PaymentStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long payment_id;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDateTime paidAt = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    @JsonBackReference
    private Booking booking;

    public Payments() {}

    public Payments(Long payment_id, PaymentMethod method, Double amount,
                    PaymentStatus paymentStatus, LocalDateTime paidAt,
                    Booking booking) {
        this.payment_id = payment_id;
        this.method = method;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paidAt = paidAt;
        this.booking = booking;
    }

    // Getters and Setters

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

	@Override
	public String toString() {
		return "Payments [payment_id=" + payment_id + ", method=" + method + ", amount=" + amount + ", paymentStatus="
				+ paymentStatus + ", paidAt=" + paidAt + ", booking=" + booking + "]";
	}
    
    
}
