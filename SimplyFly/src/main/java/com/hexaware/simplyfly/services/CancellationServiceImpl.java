package com.hexaware.simplyfly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.dto.CancellationDTO;
import com.hexaware.simplyfly.entities.Booking;
import com.hexaware.simplyfly.entities.Cancellation;
import com.hexaware.simplyfly.entities.User;
import com.hexaware.simplyfly.exceptions.BookingNotFoundException;
import com.hexaware.simplyfly.exceptions.CancellationNotFoundException;
import com.hexaware.simplyfly.exceptions.UserNotFoundException;
import com.hexaware.simplyfly.repositories.BookingRepository;
import com.hexaware.simplyfly.repositories.CancellationRepository;
import com.hexaware.simplyfly.repositories.UserRepository;

@Service
public class CancellationServiceImpl implements ICancellationService {

    @Autowired
    private CancellationRepository cancellationRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Cancellation createCancellation(CancellationDTO dto) throws BookingNotFoundException, UserNotFoundException {
        Booking booking = bookingRepository.findById(dto.getBooking_id())
        		.orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + dto.getBooking_id()));

        User cancelledByUser = userRepository.findById(dto.getCancelled_by_user_id())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + dto.getCancelled_by_user_id()));

        Cancellation cancellation = new Cancellation();
        cancellation.setReason(dto.getReason());
        cancellation.setRefundAmount(dto.getRefundAmount());
        cancellation.setRefundStatus(Cancellation.RefundStatus.valueOf(dto.getRefundStatus().name()));  // convert enum here
        cancellation.setCancelledAt(dto.getCancelledAt());
        cancellation.setBooking(booking);
        cancellation.setCancelledBy(cancelledByUser);  // corrected method name

        return cancellationRepository.save(cancellation);
    }

    @Override
    public Cancellation updateCancellation(Long cancellation_id, CancellationDTO dto) throws CancellationNotFoundException, UserNotFoundException, BookingNotFoundException {
        Cancellation cancellation = cancellationRepository.findById(cancellation_id)
                .orElseThrow(() -> new CancellationNotFoundException("Cancellation not found with ID: " + cancellation_id));

        Booking booking = bookingRepository.findById(dto.getBooking_id())
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + dto.getBooking_id()));

        User cancelledByUser = userRepository.findById(dto.getCancelled_by_user_id())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + dto.getCancelled_by_user_id()));

        cancellation.setReason(dto.getReason());
        cancellation.setRefundAmount(dto.getRefundAmount());
        cancellation.setRefundStatus(Cancellation.RefundStatus.valueOf(dto.getRefundStatus().name()));  // convert enum here
        cancellation.setCancelledAt(dto.getCancelledAt());
        cancellation.setBooking(booking);
        cancellation.setCancelledBy(cancelledByUser);  // corrected method name

        return cancellationRepository.save(cancellation);
    }

    @Override
    public boolean deleteCancellation(Long cancellation_id) throws CancellationNotFoundException {
        if (!cancellationRepository.existsById(cancellation_id)) {
            throw new CancellationNotFoundException("Cancellation not found with ID: " + cancellation_id);
        }
        cancellationRepository.deleteById(cancellation_id);
        return true;
    }

    @Override
    public Cancellation getCancellationById(Long cancellation_id) throws CancellationNotFoundException {
        return cancellationRepository.findById(cancellation_id)
                .orElseThrow(() -> new CancellationNotFoundException("Cancellation not found with ID: " + cancellation_id));
    }

    @Override
    public List<Cancellation> getAllCancellations() {
        return cancellationRepository.findAll();
    }
}
