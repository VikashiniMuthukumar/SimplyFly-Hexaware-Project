package com.hexaware.simplyfly.dto;

import java.time.LocalDateTime;

public class CancellationDTO {

    public enum RefundStatus {
        INITIATED, SUCCESSFUL, FAILED
    }

    private Long cancellation_id;
    private String reason;
    private Double refundAmount;
    private RefundStatus refundStatus;
    private LocalDateTime cancelledAt;

    private Long booking_id;
    private Long cancelled_by_user_id;

    public CancellationDTO() {
        super();
    }

    public CancellationDTO(Long cancellation_id, String reason, Double refundAmount,
                           RefundStatus refundStatus, LocalDateTime cancelledAt,
                           Long booking_id, Long cancelled_by_user_id) {
        this.cancellation_id = cancellation_id;
        this.reason = reason;
        this.refundAmount = refundAmount;
        this.refundStatus = refundStatus;
        this.cancelledAt = cancelledAt;
        this.booking_id = booking_id;
        this.cancelled_by_user_id = cancelled_by_user_id;
    }

    public Long getCancellation_id() {
        return cancellation_id;
    }

    public void setCancellation_id(Long cancellation_id) {
        this.cancellation_id = cancellation_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public RefundStatus getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(RefundStatus refundStatus) {
        this.refundStatus = refundStatus;
    }

    public LocalDateTime getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(LocalDateTime cancelledAt) {
        this.cancelledAt = cancelledAt;
    }

    public Long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }

    public Long getCancelled_by_user_id() {
        return cancelled_by_user_id;
    }

    public void setCancelled_by_user_id(Long cancelled_by_user_id) {
        this.cancelled_by_user_id = cancelled_by_user_id;
    }
}
