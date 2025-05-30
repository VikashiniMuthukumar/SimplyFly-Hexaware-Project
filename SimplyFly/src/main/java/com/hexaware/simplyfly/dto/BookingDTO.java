package com.hexaware.simplyfly.dto;

import java.time.LocalDateTime;

import com.hexaware.simplyfly.enums.BookingStatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BookingDTO {

    private Long booking_id;

    @NotNull
    private LocalDateTime bookedAt;

    @NotNull
    private BookingStatus status;

    @NotNull
    @Positive
    private Double totalFare;

    @NotNull
    @Positive
    private Long user_id;

    @NotNull
    @Positive
    private Long route_id;

    @NotNull
    @Positive
    private Long payment_id;

    private Long cancellation_id;  // Nullable

	public BookingDTO() {
		super();
	}

	public BookingDTO(Long booking_id, @NotNull LocalDateTime bookedAt, @NotNull BookingStatus status,
			@NotNull @Positive Double totalFare, @NotNull @Positive Long user_id, @NotNull @Positive Long route_id,
			@NotNull @Positive Long payment_id, Long cancellation_id) {
		super();
		this.booking_id = booking_id;
		this.bookedAt = bookedAt;
		this.status = status;
		this.totalFare = totalFare;
		this.user_id = user_id;
		this.route_id = route_id;
		this.payment_id = payment_id;
		this.cancellation_id = cancellation_id;
	}

	public Long getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}

	public LocalDateTime getBookedAt() {
		return bookedAt;
	}

	public void setBookedAt(LocalDateTime bookedAt) {
		this.bookedAt = bookedAt;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getRoute_id() {
		return route_id;
	}

	public void setRoute_id(Long route_id) {
		this.route_id = route_id;
	}

	public Long getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}

	public Long getCancellation_id() {
		return cancellation_id;
	}

	public void setCancellation_id(Long cancellation_id) {
		this.cancellation_id = cancellation_id;
	}

	@Override
	public String toString() {
		return "BookingDTO [booking_id=" + booking_id + ", bookedAt=" + bookedAt + ", status=" + status + ", totalFare="
				+ totalFare + ", user_id=" + user_id + ", route_id=" + route_id + ", payment_id=" + payment_id
				+ ", cancellation_id=" + cancellation_id + "]";
	}

    
}
