package com.example.library.management.dto;

import com.example.library.management.domain.Book;
import com.example.library.management.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookIssueRequestDto {

    private Long id;

    private Long book;

    private Long student;

    private LocalDate issueDate;

    private LocalDate returnDate;
}
