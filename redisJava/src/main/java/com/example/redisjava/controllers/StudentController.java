package com.example.redisjava.controllers;


import com.example.redisjava.models.Student;
import com.example.redisjava.repository.Impl.RedisStudentRepository;
import com.example.redisjava.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    private Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private RedisStudentRepository redisStudentRepository;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<Object> index() {
        redisStudentRepository.add(new Student(new Random().nextLong(), StringUtils.randomString(5)));
        return ResponseEntity.ok(redisStudentRepository.findAll());
    }
}
