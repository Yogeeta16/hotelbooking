package com.app.dto;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor 
public class GuestResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    
    // Constructors, getters, and setters
}
