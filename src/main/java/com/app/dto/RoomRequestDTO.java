package com.app.dto;

import java.math.BigDecimal;

import com.app.entities.RoomType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequestDTO {
    private String roomNumber;
    private RoomType type;
    private BigDecimal price;
}
