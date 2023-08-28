package com.example.library.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

    private Long id;

    private Integer idNumber;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String telephone;

    private LocalDate registeredDate;

    private LocalDate terminatedDate;
}
