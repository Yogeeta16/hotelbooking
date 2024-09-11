package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AvailableRoomDTO;
import com.app.dto.ReservationDTO;
import com.app.dto.RoomRequestDTO;
import com.app.dto.RoomResponseDTO;
import com.app.service.RoomService;


@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomResponseDTO> createRoom(@RequestBody RoomRequestDTO roomDTO) {
        System.out.println("Received RoomRequestDTO: " + roomDTO); // Debugging
        System.out.println("Room Number: " + roomDTO.getRoomNumber());
        System.out.println("Type: " + roomDTO.getType());
        System.out.println("Price: " + roomDTO.getPrice());
        RoomResponseDTO responseDTO = roomService.createRoom(roomDTO);
        return ResponseEntity.ok(responseDTO);
    }
    
    @GetMapping
    public ResponseEntity<List<RoomResponseDTO>> getAllRooms() {
        List<RoomResponseDTO> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }
    
    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<ReservationDTO> reservations = roomService.getAllReservations();
        // Implement proper response handling
        return ResponseEntity.ok(reservations);
    }
    
    @GetMapping("/{roomId}/reservations")
    public ResponseEntity<List<ReservationDTO>> getReservationsForRoom(@PathVariable Long roomId) {
        List<ReservationDTO> reservations = roomService.getReservationsForRoom(roomId);
        // Implement proper response handling
        return ResponseEntity.ok(reservations);
    }
    
    @GetMapping("/{roomId}/availability/{date}")
    public ResponseEntity<String> checkRoomAvailability(@PathVariable Long roomId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        boolean available = roomService.isRoomAvailable(roomId, date);
        String response = available ? "Room is available on " + date : "Room is not available on " + date;
        return ResponseEntity.ok(response);
    }
    @GetMapping("/available/{checkInDate}")
    public ResponseEntity<List<AvailableRoomDTO>> getAvailableRooms(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate) {
        List<AvailableRoomDTO> availableRooms = roomService.getAvailableRooms(checkInDate);
        return ResponseEntity.ok(availableRooms);
    }

}
