package com.example.library.management.repository.read;

import com.example.library.management.domain.Book;
import com.example.library.management.domain.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BookIssueReaderRepository extends JpaRepository<BookIssue, Long> {

    Optional<BookIssue> findByBook(Book book);
}
