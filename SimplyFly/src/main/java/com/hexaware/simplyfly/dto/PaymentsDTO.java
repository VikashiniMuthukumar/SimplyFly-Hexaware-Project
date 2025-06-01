package com.hexaware.simplyfly.dto;

import java.time.LocalDateTime;

import com.hexaware.simplyfly.enums.PaymentMethod;
import com.hexaware.simplyfly.enums.PaymentStatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PaymentsDTO {

    private Long payment_id;

    @NotNull
    private PaymentMethod method;

    @NotNull
    @PositiveOrZero(message = "Amount must be zero or positive")
    private Double amount;

    @NotNull
    private PaymentStatus paymentStatus;

    private LocalDateTime paidAt;

    @NotNull
    private Long booking_id;

    public PaymentsDTO() {}

    public PaymentsDTO(Long payment_id, PaymentMethod method, Double amount,
                       PaymentStatus paymentStatus, LocalDateTime paidAt,
                       Long booking_id) {
        this.payment_id = payment_id;
        this.method = method;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paidAt = paidAt;
        this.booking_id = booking_id;
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

    public Long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }

	@Override
	public String toString() {
		return "PaymentsDTO [payment_id=" + payment_id + ", method=" + method + ", amount=" + amount
				+ ", paymentStatus=" + paymentStatus + ", paidAt=" + paidAt + ", booking_id=" + booking_id + "]";
	}
    
    
}
