package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.GuestRepository;
import com.app.dao.ReservationRepository;
import com.app.dao.RoomRepository;
import com.app.dto.ReservationRequestDTO;
import com.app.dto.ReservationResponseDTO;
import com.app.entities.Guest;
import com.app.entities.Reservation;
import com.app.entities.Room;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Autowired
    private RoomRepository roomRepository;
    
    @Autowired
    private GuestRepository guestRepository;
    
    @Autowired
    private ModelMapper modelMapper; // Assuming you have configured ModelMapper
    
    public ReservationResponseDTO createReservation(ReservationRequestDTO reservationDTO) {

        
        Room room = roomRepository.findById(reservationDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        
        if (!room.isAvailable()) {
            throw new RuntimeException("Room is not available");
        }
        
        Guest guest = guestRepository.findById(reservationDTO.getGuestId())
                .orElseThrow(() -> new RuntimeException("Guest not found"));
        
        Reservation reservation = new Reservation();
        reservation.setGuest(guest);
        reservation.setCheckInDate(reservationDTO.getCheckInDate());
        reservation.setCheckOutDate(reservationDTO.getCheckOutDate());
        reservation.setRoom(room);
     
        
        reservation = reservationRepository.save(reservation);
        
        // Convert entity to response DTO
        ReservationResponseDTO responseDTO = modelMapper.map(reservation, ReservationResponseDTO.class);
        
        return responseDTO;
    }
    
    public void cancelReservation(Long reservationId) {
        // Implement logic to cancel reservation
        reservationRepository.deleteById(reservationId);
    }
}
