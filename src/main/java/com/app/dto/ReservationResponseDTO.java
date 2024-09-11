package com.app.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReservationResponseDTO {
    private Long reservationId;
    private Long guestId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long roomId;
    private BigDecimal totalPrice;
    
    // Constructors, getters, and setters
}
