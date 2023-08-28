package com.example.library.management.repository.write;

import com.example.library.management.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentWriteRepository extends JpaRepository<Student, Long> {
}
