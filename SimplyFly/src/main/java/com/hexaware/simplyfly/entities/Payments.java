package com.hexaware.simplyfly.entities;

import java.time.LocalDateTime;

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
	public enum Method { UPI, CARD, NETBANKING }
    public enum Status { SUCCESS, FAILED, PENDING }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long payment_id;

    @Enumerated(EnumType.STRING)
    private Method method;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    private LocalDateTime paidAt = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

	public Payments() {
		super();
	}

	public Payments(Long payment_id, Method method, Double amount, Status paymentStatus, LocalDateTime paidAt,
			Booking booking) {
		super();
		this.payment_id = payment_id;
		this.method = method;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paidAt = paidAt;
		this.booking = booking;
	}

	public Long getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Status getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Status paymentStatus) {
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

	
}

