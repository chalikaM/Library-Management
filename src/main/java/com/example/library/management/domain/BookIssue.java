package com.example.library.management.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookIssues")
public class BookIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Many-to-One mapping with Book entity
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // Many-to-One mapping with Student entity
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "is_received")
    private Boolean isReceived;
}
