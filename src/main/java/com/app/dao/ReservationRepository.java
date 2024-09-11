package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByRoomId(Long roomId);
    List<Reservation> findByRoomIdAndReservationDate(Long roomId, LocalDate reservationDate);
    List<Reservation> findByRoomIdAndCheckInDate(Long roomId, LocalDate checkInDate); // Corrected method
}