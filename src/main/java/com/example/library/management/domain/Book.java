package com.example.library.management.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "book_reference_number")
    private String bookReferenceNumber;

    @Column(name = "isbn")
    private String ISBN;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publication")
    private String publication;

    @Column(name = "edition")
    private String edition;

    @Column(name = "published_year")
    private Integer publishedYear;

    @Column(name = "category")
    private String category;

    @Column(name = "number_of_copies")
    private Integer numberOfCopies;
}
