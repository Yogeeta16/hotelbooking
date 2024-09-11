package com.app.entities;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;
    
    @Column(name = "check_in_date")
    private LocalDate checkInDate;
    
    @Column(name = "check_out_date")
    private LocalDate checkOutDate;
    
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    
    @Column(name = "total_price")
    private BigDecimal totalPrice;


    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    // Getters and setters
}
