package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReservationRequestDTO {
    private Long guestId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long roomId;
    
    // Getters and setters
}
