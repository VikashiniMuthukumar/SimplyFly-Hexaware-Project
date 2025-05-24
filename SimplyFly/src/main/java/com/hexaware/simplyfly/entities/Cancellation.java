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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Cancellation {
	public enum RefundStatus {
		INITIATED, SUCCESSFUL, FAILED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cancellation_id")
	private Long cancellation_id;

	private String reason;

	private Double refundAmount;

	@Enumerated(EnumType.STRING)
	private RefundStatus refundStatus;

	private LocalDateTime cancelledAt = LocalDateTime.now();

	@OneToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;

	@ManyToOne
	@JoinColumn(name = "cancelled_by")
	private User cancelledBy;

	public Cancellation() {
		super();
	}

	public Cancellation(Long cancellation_id, String reason, Double refundAmount, RefundStatus refundStatus,
			LocalDateTime cancelledAt, Booking booking, User cancelledBy) {
		super();
		this.cancellation_id = cancellation_id;
		this.reason = reason;
		this.refundAmount = refundAmount;
		this.refundStatus = refundStatus;
		this.cancelledAt = cancelledAt;
		this.booking = booking;
		this.cancelledBy = cancelledBy;
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

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public User getCancelledBy() {
		return cancelledBy;
	}

	public void setCancelledBy(User cancelledBy) {
		this.cancelledBy = cancelledBy;
	}

	
}
