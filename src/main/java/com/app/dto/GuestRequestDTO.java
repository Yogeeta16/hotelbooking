package com.app.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestRequestDTO {
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
