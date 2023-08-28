package com.example.library.management.service.impl;

import com.example.library.management.domain.Book;
import com.example.library.management.domain.BookIssue;
import com.example.library.management.dto.SearchResultResponseDto;
import com.example.library.management.repository.read.BookIssueReaderRepository;
import com.example.library.management.repository.read.BookReaderRepository;
import com.example.library.management.repository.read.StudentReaderRepository;
import com.example.library.management.repository.write.BookWriterRepository;
import com.example.library.management.rest.BookController;
import com.example.library.management.service.BookService;
import com.example.library.management.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookWriterRepository writerRepository;

    @Autowired
    BookReaderRepository readerRepository;

    @Autowired
    BookIssueReaderRepository bookIssueReaderRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public void save(Book book) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("saveRequest");

        writerRepository.save(book);

        LOGGER.info("saveResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));
    }

    @Override
    public List<SearchResultResponseDto> searchBooks(String keyword) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("searchBooksRequest");

        List<SearchResultResponseDto> searchResultResponseDtoList = new ArrayList<>();
        List<Book> books = readerRepository.findByBookReferenceNumberOrAuthorIgnoreCaseContainingOrTitleIgnoreCaseContaining(keyword, keyword, keyword);

        for(Book book: books){

            SearchResultResponseDto searchResultResponseDto = new SearchResultResponseDto();

            searchResultResponseDto.setBookReferenceNumber(book.getBookReferenceNumber());
            searchResultResponseDto.setAuthor(book.getAuthor());
            searchResultResponseDto.setPublication(book.getPublication());
            searchResultResponseDto.setTitle(book.getTitle());

            Optional<BookIssue> bookIssue = bookIssueReaderRepository.findByBook(book);

            if(bookIssue.isPresent()){
                searchResultResponseDto.setFirstName(bookIssue.get().getStudent().getFirstName());
                searchResultResponseDto.setLastName(bookIssue.get().getStudent().getLastName());
                searchResultResponseDto.setReturnDate(bookIssue.get().getReturnDate());
                searchResultResponseDto.setIssueDate(bookIssue.get().getIssueDate());
            }
            searchResultResponseDtoList.add(searchResultResponseDto);
        }

        LOGGER.info("saveBooksResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));
        return searchResultResponseDtoList;
    }

    @Override
    public List<SearchResultResponseDto> getALl() {

        long startTime = System.currentTimeMillis();
        LOGGER.info("getALlRequest");

        List<SearchResultResponseDto> searchResultResponseDtoList = new ArrayList<>();
        List<Book> books = readerRepository.findAll();

        for(Book book: books){

            SearchResultResponseDto searchResultResponseDto = new SearchResultResponseDto();

            searchResultResponseDto.setBookReferenceNumber(book.getBookReferenceNumber());
            searchResultResponseDto.setAuthor(book.getAuthor());
            searchResultResponseDto.setPublication(book.getPublication());
            searchResultResponseDto.setTitle(book.getTitle());

            Optional<BookIssue> bookIssue = bookIssueReaderRepository.findByBook(book);

            if(bookIssue.isPresent()){
                searchResultResponseDto.setFirstName(bookIssue.get().getStudent().getFirstName());
                searchResultResponseDto.setLastName(bookIssue.get().getStudent().getLastName());
                searchResultResponseDto.setReturnDate(bookIssue.get().getReturnDate());
                searchResultResponseDto.setIssueDate(bookIssue.get().getIssueDate());
            }
            searchResultResponseDtoList.add(searchResultResponseDto);
        }

        LOGGER.info("saveBooksResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));
        return searchResultResponseDtoList;

    }
}
