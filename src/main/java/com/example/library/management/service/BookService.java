package com.example.library.management.service;

import com.example.library.management.domain.Book;
import com.example.library.management.dto.SearchResultResponseDto;
import java.util.List;

public interface BookService {

    void save(Book book);

    List<SearchResultResponseDto> searchBooks(String keyword);

    List<SearchResultResponseDto> getALl();
}
