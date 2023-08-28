package com.example.library.management.repository.write;

import com.example.library.management.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookWriterRepository extends JpaRepository<Book, Long> {


}
