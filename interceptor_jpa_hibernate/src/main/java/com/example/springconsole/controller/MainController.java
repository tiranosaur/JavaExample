package com.example.springconsole.controller;

import com.example.springconsole.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    private final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    UserRepository userRepository;


    @RequestMapping(value = {"/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> home() {
        var result = userRepository.findByUsername("tiranosaur");
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = {"/p"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> home2() {
        var result = userRepository.findByPassword("ccc");
        return ResponseEntity.ok(result);
    }
}