package com.hexaware.simplyfly.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PaymentsDTO {
    public enum Method { UPI, CARD, NETBANKING }
    public enum Status { SUCCESS, FAILED, PENDING }

    private Long payment_id;

    @NotNull
    private Method method;

    @NotNull
    @PositiveOrZero(message = "Amount must be zero or positive")
    private Double amount;

    @NotNull
    private Status paymentStatus;

    private LocalDateTime paidAt;

    @NotNull
    private Long booking_id;

    public PaymentsDTO() {}

    public PaymentsDTO(Long payment_id, Method method, Double amount,
                       Status paymentStatus, LocalDateTime paidAt,
                       Long booking_id) {
        this.payment_id = payment_id;
        this.method = method;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paidAt = paidAt;
        this.booking_id = booking_id;
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

    public Long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }
}
