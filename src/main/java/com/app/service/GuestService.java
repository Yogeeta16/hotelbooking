package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.GuestRepository;
import com.app.dto.GuestRequestDTO;
import com.app.dto.GuestResponseDTO;
import com.app.entities.Guest;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;
    
    @Autowired
    private ModelMapper modelMapper; // Assuming you have configured ModelMapper
    
    public GuestResponseDTO createGuest(GuestRequestDTO guestDTO) {
        Guest guest = new Guest();
        guest.setFirstName(guestDTO.getFirstName());
        guest.setLastName(guestDTO.getLastName());
        guest.setDob(guestDTO.getDob());
        
        Guest savedGuest = guestRepository.save(guest);
        
        return modelMapper.map(savedGuest, GuestResponseDTO.class);
    }
    
    public List<GuestResponseDTO> getAllGuests() {
        List<Guest> guests = guestRepository.findAll();
        return guests.stream()
                .map(guest -> modelMapper.map(guest, GuestResponseDTO.class))
                .collect(Collectors.toList());
    }
}
