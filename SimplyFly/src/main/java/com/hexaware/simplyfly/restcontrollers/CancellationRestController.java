package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.simplyfly.dto.CancellationDTO;
import com.hexaware.simplyfly.entities.Cancellation;
import com.hexaware.simplyfly.exceptions.BookingNotFoundException;
import com.hexaware.simplyfly.exceptions.CancellationNotFoundException;
import com.hexaware.simplyfly.exceptions.UserNotFoundException;
import com.hexaware.simplyfly.services.ICancellationService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/cancellations")
public class CancellationRestController {

    @Autowired
    private ICancellationService cancellationService;

    @PostMapping
    public ResponseEntity<Cancellation> createCancellation(@Valid @RequestBody CancellationDTO dto) throws BookingNotFoundException, UserNotFoundException {
        log.info("Creating cancellation with data: {}", dto);
        Cancellation cancellation = cancellationService.createCancellation(dto);
        log.info("Cancellation created with ID: {}", cancellation.getCancellation_id());
        return new ResponseEntity<>(cancellation, HttpStatus.CREATED);
    }

    @PutMapping("/{cancellationId}")
    public ResponseEntity<Cancellation> updateCancellation(@PathVariable Long cancellationId, @Valid @RequestBody CancellationDTO dto) throws CancellationNotFoundException, UserNotFoundException, BookingNotFoundException {
        log.info("Updating cancellation with ID: {}", cancellationId);
        Cancellation cancellation = cancellationService.updateCancellation(cancellationId, dto);
        log.info("Cancellation updated: {}", cancellation);
        return ResponseEntity.ok(cancellation);
    }

    @DeleteMapping("/{cancellationId}")
    public ResponseEntity<Void> deleteCancellation(@PathVariable Long cancellationId) throws CancellationNotFoundException {
        log.warn("Deleting cancellation with ID: {}", cancellationId);
        cancellationService.deleteCancellation(cancellationId);
        log.info("Cancellation deleted with ID: {}", cancellationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cancellationId}")
    public ResponseEntity<Cancellation> getCancellationById(@PathVariable Long cancellationId) throws CancellationNotFoundException {
        log.info("Fetching cancellation with ID: {}", cancellationId);
        Cancellation cancellation = cancellationService.getCancellationById(cancellationId);
        log.info("Cancellation fetched: {}", cancellation);
        return ResponseEntity.ok(cancellation);
    }

    @GetMapping
    public ResponseEntity<List<Cancellation>> getAllCancellations() {
        log.info("Fetching all cancellations");
        List<Cancellation> cancellations = cancellationService.getAllCancellations();
        log.info("Total cancellations fetched: {}", cancellations.size());
        return ResponseEntity.ok(cancellations);
    }
}
