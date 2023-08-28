package com.example.library.management.rest;

import com.example.library.management.domain.BookIssue;
import com.example.library.management.dto.BookIssueRequestDto;
import com.example.library.management.dto.LibraryManagementAPIResponse;
import com.example.library.management.service.BookIssueService;
import com.example.library.management.util.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book-issues")
@CrossOrigin(origins = "*")
public class BookIssueController {

    @Autowired
    BookIssueService service;

    @Autowired
    private ObjectMapper mapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookIssueController.class);

    @PostMapping
    public LibraryManagementAPIResponse saveBookIssues(@RequestBody BookIssueRequestDto requestDto) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("saveBookIssuesRequest : request={}",requestDto.toString());

        service.save(requestDto);

        LOGGER.info("saveBookIssuesResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));
        return new LibraryManagementAPIResponse(HttpStatus.OK.value(), "Book Issue Successfully received", null);

    }
}
