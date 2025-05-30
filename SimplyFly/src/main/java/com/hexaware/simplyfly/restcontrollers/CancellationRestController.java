package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import com.hexaware.simplyfly.dto.CancellationDTO;
import com.hexaware.simplyfly.entities.Cancellation;
import com.hexaware.simplyfly.exceptions.BookingNotFoundException;
import com.hexaware.simplyfly.exceptions.CancellationNotFoundException;
import com.hexaware.simplyfly.exceptions.UserNotFoundException;
import com.hexaware.simplyfly.services.ICancellationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cancellations")
public class CancellationRestController {

    @Autowired
    private ICancellationService cancellationService;

    @PostMapping
    public ResponseEntity<Cancellation> createCancellation(@RequestBody CancellationDTO dto) throws BookingNotFoundException, UserNotFoundException {
        Cancellation cancellation = cancellationService.createCancellation(dto);
        return new ResponseEntity<>(cancellation, HttpStatus.CREATED);
    }

    @PutMapping("/{cancellationId}")
    public ResponseEntity<Cancellation> updateCancellation(@PathVariable Long cancellationId, @RequestBody CancellationDTO dto) throws CancellationNotFoundException, UserNotFoundException, BookingNotFoundException {
        Cancellation cancellation = cancellationService.updateCancellation(cancellationId, dto);
        return ResponseEntity.ok(cancellation);
    }

    @DeleteMapping("/{cancellationId}")
    public ResponseEntity<Void> deleteCancellation(@PathVariable Long cancellationId) throws CancellationNotFoundException {
        cancellationService.deleteCancellation(cancellationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cancellationId}")
    public ResponseEntity<Cancellation> getCancellationById(@PathVariable Long cancellationId) throws CancellationNotFoundException {
        Cancellation cancellation = cancellationService.getCancellationById(cancellationId);
        return ResponseEntity.ok(cancellation);
    }

    @GetMapping
    public ResponseEntity<List<Cancellation>> getAllCancellations() {
        return ResponseEntity.ok(cancellationService.getAllCancellations());
    }
}
