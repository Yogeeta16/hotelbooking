package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ReservationRepository;
import com.app.dao.RoomRepository;
import com.app.dto.AvailableRoomDTO;

import com.app.dto.ReservationDTO;
import com.app.dto.RoomRequestDTO;
import com.app.dto.RoomResponseDTO;

import com.app.entities.Reservation;
import com.app.entities.Room;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    
    
    @Autowired
    private ModelMapper modelMapper;


    public RoomResponseDTO createRoom(RoomRequestDTO roomDTO) {
      
        Room room = modelMapper.map(roomDTO, Room.class);
        room = roomRepository.save(room);
        return modelMapper.map(room, RoomResponseDTO.class);
    }

    public List<RoomResponseDTO> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                    .map(room -> modelMapper.map(room, RoomResponseDTO.class))
                    .collect(Collectors.toList());
    }
    
    public List<ReservationDTO> getAllReservations()
    {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(reservation -> modelMapper.map(reservation, ReservationDTO.class))
                .collect(Collectors.toList());
    }
    

    public List<ReservationDTO> getReservationsForRoom(Long roomId) {
        List<Reservation> reservations = reservationRepository.findByRoomId(roomId);
        return reservations.stream()
                .map(reservation -> modelMapper.map(reservation, ReservationDTO.class))
                .collect(Collectors.toList());
    }
    
    public boolean isRoomAvailable(Long roomId, LocalDate date) {
        // Check if there are any reservations for the room on the given date
        List<Reservation> reservations = reservationRepository.findByRoomIdAndReservationDate(roomId, date);
        return reservations.isEmpty(); // Room is available if no reservations found
    }
    public List<AvailableRoomDTO> getAvailableRooms(LocalDate checkInDate) {
        List<Room> availableRooms = roomRepository.findByAvailableTrue();
        List<AvailableRoomDTO> availableRoomDTOs = new ArrayList<>();
        
        for (Room room : availableRooms) {
            // Example logic: Check if the room is available on the given check-in date
            boolean isAvailableOnDate = true; // Implement your logic here
            
            if (isAvailableOnDate) {
                AvailableRoomDTO dto = new AvailableRoomDTO();
                dto.setId(room.getId());
                dto.setRoomNumber(room.getRoomNumber());
                dto.setType(room.getType());
                dto.setPrice(room.getPrice());
                
                availableRoomDTOs.add(dto);
            }
        }
        
        return availableRoomDTOs;
    }
}

