package com.hexaware.simplyfly.dto;

import java.time.LocalDateTime;

import com.hexaware.simplyfly.enums.RefundStatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CancellationDTO {

    private Long cancellation_id;

    @NotNull
    private String reason;

    @NotNull
    private Double refundAmount;

    @NotNull
    private RefundStatus refundStatus;

    @NotNull
    private LocalDateTime cancelledAt;

    @NotNull
    @Positive
    private Long booking_id;

    @NotNull
    @Positive
    private Long cancelled_by_user_id;

    public CancellationDTO() {
        super();
    }

	public CancellationDTO(Long cancellation_id, String reason, Double refundAmount,
			RefundStatus refundStatus, LocalDateTime cancelledAt, Long booking_id,
			Long cancelled_by_user_id) {
		super();
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

	@Override
	public String toString() {
		return "CancellationDTO [cancellation_id=" + cancellation_id + ", reason=" + reason + ", refundAmount="
				+ refundAmount + ", refundStatus=" + refundStatus + ", cancelledAt=" + cancelledAt + ", booking_id="
				+ booking_id + ", cancelled_by_user_id=" + cancelled_by_user_id + "]";
	}

	
    
}
