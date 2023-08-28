package com.example.library.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResultResponseDto {

    private String bookReferenceNumber;

    private String title;

    private String author;

    private String publication;

    private String firstName;

    private String lastName;

    private LocalDate issueDate;

    private LocalDate returnDate;
}
