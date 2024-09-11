package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.GuestRequestDTO;
import com.app.dto.GuestResponseDTO;
import com.app.service.GuestService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/guests")
public class GuestController {
    @Autowired
    private GuestService guestService;
    
    @PostMapping
    public ResponseEntity<GuestResponseDTO> createGuest(@RequestBody GuestRequestDTO guestDTO) {
        GuestResponseDTO responseDTO = guestService.createGuest(guestDTO);
        return ResponseEntity.ok(responseDTO);
    }
    
    @GetMapping
    public ResponseEntity<List<GuestResponseDTO>> getAllGuests() {
        List<GuestResponseDTO> guests = guestService.getAllGuests();
        return ResponseEntity.ok(guests);
    }
}
