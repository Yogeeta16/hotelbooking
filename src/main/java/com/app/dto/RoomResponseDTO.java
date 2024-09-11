package com.app.dto;

import java.math.BigDecimal;

import com.app.entities.RoomType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomResponseDTO {
    private Long id;
    private String roomNumber;
    private RoomType type;
    private BigDecimal price;
    
    // Constructors, getters, and setters
}
