package com.example.library.management.repository.read;

import com.example.library.management.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookReaderRepository extends JpaRepository<Book, Long> {

    List<Book> findByBookReferenceNumberOrAuthorIgnoreCaseContainingOrTitleIgnoreCaseContaining(String bookReferenceNumber, String author, String title);
}
