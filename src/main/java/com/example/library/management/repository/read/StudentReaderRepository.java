package com.example.library.management.repository.read;

import com.example.library.management.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReaderRepository extends JpaRepository<Student, Long> {
}
