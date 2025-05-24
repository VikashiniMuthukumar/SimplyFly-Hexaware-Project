package com.hexaware.simplyfly.services;

import com.hexaware.simplyfly.entities.Cancellation;

public interface ICancellationService {

	Cancellation cancelBooking(Long bookingId, String reason);
    Cancellation getCancellationDetails(Long cancellationId);
}
