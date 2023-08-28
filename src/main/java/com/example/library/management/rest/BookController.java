package com.example.library.management.rest;

import com.example.library.management.domain.Book;
import com.example.library.management.dto.BookRequestDto;
import com.example.library.management.dto.LibraryManagementAPIResponse;
import com.example.library.management.dto.SearchResultResponseDto;
import com.example.library.management.service.BookService;
import com.example.library.management.util.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    BookService service;

    @Autowired
    private ObjectMapper mapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @PostMapping
    public LibraryManagementAPIResponse saveBooks(@RequestBody BookRequestDto requestDto) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("saveBooksRequest : request={}",requestDto.toString());

        Book book = mapper.convertValue(requestDto, Book.class);
        service.save(book);

        LOGGER.info("saveBooksResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));

        return new LibraryManagementAPIResponse(HttpStatus.OK.value(), "Book Successfully received", null);

    }

    @GetMapping("/search")
    public LibraryManagementAPIResponse searchBooks(@RequestParam String keyword) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("saveBooksRequest : keyword={}",keyword);

        List<SearchResultResponseDto> searchResultResponseDtoList = service.searchBooks(keyword);

        LOGGER.info("saveBooksResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));

        return new LibraryManagementAPIResponse(HttpStatus.OK.value(), "Result Successfully received", searchResultResponseDtoList);
    }

    @GetMapping("/all")
    public LibraryManagementAPIResponse getAllResults() {

        long startTime = System.currentTimeMillis();
        LOGGER.info("getAllResultsRequest");

        List<SearchResultResponseDto> searchResultResponseDtoList = service.getALl();

        LOGGER.info("getAllResultsResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));
        return new LibraryManagementAPIResponse(HttpStatus.OK.value(), "Results Successfully received", searchResultResponseDtoList);
    }


}
