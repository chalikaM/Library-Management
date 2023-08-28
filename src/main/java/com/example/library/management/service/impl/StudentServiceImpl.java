package com.example.library.management.service.impl;

import com.example.library.management.domain.Student;
import com.example.library.management.repository.write.StudentWriteRepository;
import com.example.library.management.service.StudentService;
import com.example.library.management.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentWriteRepository writeRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public void save(Student student) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("saveBooksRequest");

        writeRepository.save(student);

        LOGGER.info("saveResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));
    }
}
