package com.hexaware.simplyfly.services;

import java.util.List;

import com.hexaware.simplyfly.dto.CancellationDTO;
import com.hexaware.simplyfly.entities.Cancellation;
import com.hexaware.simplyfly.exceptions.BookingNotFoundException;
import com.hexaware.simplyfly.exceptions.CancellationNotFoundException;
import com.hexaware.simplyfly.exceptions.UserNotFoundException;

public interface ICancellationService {
	Cancellation createCancellation(CancellationDTO dto) throws BookingNotFoundException, UserNotFoundException ;

	Cancellation updateCancellation(Long cancellation_id, CancellationDTO dto) throws CancellationNotFoundException, UserNotFoundException, BookingNotFoundException;

	boolean deleteCancellation(Long cancellation_id) throws CancellationNotFoundException;

	Cancellation getCancellationById(Long cancellation_id) throws CancellationNotFoundException;

	List<Cancellation> getAllCancellations();
}
