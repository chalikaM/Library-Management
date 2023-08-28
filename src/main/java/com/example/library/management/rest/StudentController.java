package com.example.library.management.rest;

import com.example.library.management.domain.Student;
import com.example.library.management.dto.LibraryManagementAPIResponse;
import com.example.library.management.dto.StudentRequestDto;
import com.example.library.management.service.StudentService;
import com.example.library.management.util.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    StudentService service;

    @Autowired
    private ObjectMapper mapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @PostMapping
    public LibraryManagementAPIResponse saveStudents(@RequestBody StudentRequestDto requestDto) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("saveStudentsRequest : request={}",requestDto.toString());

        Student student = mapper.convertValue(requestDto, Student.class);
        service.save(student);

        LOGGER.info("saveStudentsResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));
        return new LibraryManagementAPIResponse(HttpStatus.OK.value(), "Student Successfully saved", null);

    }
}
