package com.example.library.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {

    private long id;

    private String bookReferenceNumber;

    private String ISBN;

    private String title;

    private String author;

    private String publication;

    private String edition;

    private Integer publishedYear;

    private String category;

    private Integer numberOfCopies;
}
