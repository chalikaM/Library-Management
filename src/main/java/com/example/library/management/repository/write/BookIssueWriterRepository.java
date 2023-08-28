package com.example.library.management.repository.write;

import com.example.library.management.domain.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIssueWriterRepository extends JpaRepository<BookIssue, Long> {
}
