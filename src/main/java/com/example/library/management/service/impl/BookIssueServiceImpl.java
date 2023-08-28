package com.example.library.management.service.impl;

import com.example.library.management.domain.Book;
import com.example.library.management.domain.BookIssue;
import com.example.library.management.domain.Student;
import com.example.library.management.dto.BookIssueRequestDto;
import com.example.library.management.repository.write.BookIssueWriterRepository;
import com.example.library.management.service.BookIssueService;
import com.example.library.management.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookIssueServiceImpl implements BookIssueService {

    @Autowired
    BookIssueWriterRepository writerRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookIssueServiceImpl.class);

    @Override
    public void save(BookIssueRequestDto requestDto) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("saveRequest");

        Book book = new Book();
        Student student = new Student();
        BookIssue newBookIssue = new BookIssue();

        book.setId(requestDto.getBook());
        student.setId(requestDto.getStudent());

        newBookIssue.setBook(book);
        newBookIssue.setStudent(student);
        newBookIssue.setIssueDate(requestDto.getIssueDate());
        newBookIssue.setReturnDate(requestDto.getReturnDate());

        LOGGER.info("saveResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));

        writerRepository.save(newBookIssue);

    }
}
