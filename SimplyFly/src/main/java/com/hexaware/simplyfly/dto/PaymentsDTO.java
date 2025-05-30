package com.hexaware.simplyfly.dto;

import java.time.LocalDateTime;

public class PaymentsDTO {

    public enum Method { UPI, CARD, NETBANKING }
    public enum Status { SUCCESS, FAILED, PENDING }

    private Long payment_id;
    private Method method;
    private Double amount;
    private Status paymentStatus;
    private LocalDateTime paidAt;
    private Long booking_id;  // Reference to associated booking

    public PaymentsDTO() {
        // Default constructor
    }

    public PaymentsDTO(Long payment_id, Method method, Double amount, Status paymentStatus, LocalDateTime paidAt, Long booking_id) {
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
