package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ReservationRequestDTO;
import com.app.dto.ReservationResponseDTO;
import com.app.service.ReservationService;


@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    
    @PostMapping
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody ReservationRequestDTO reservationDTO) {
        ReservationResponseDTO responseDTO = reservationService.createReservation(reservationDTO);
        return ResponseEntity.ok(responseDTO);
    }
    
    @DeleteMapping("/{reservationId}")
    public ResponseEntity<?> cancelReservation(@PathVariable Long reservationId) {
        reservationService.cancelReservation(reservationId);
        return ResponseEntity.ok("Reservation canceled with ID: " + reservationId);
    }
}
