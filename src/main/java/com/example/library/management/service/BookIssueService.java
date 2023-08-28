package com.example.library.management.service;
import com.example.library.management.domain.BookIssue;
import com.example.library.management.dto.BookIssueRequestDto;

public interface BookIssueService {

    void save(BookIssueRequestDto requestDto);
}
