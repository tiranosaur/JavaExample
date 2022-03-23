package com.example.springconsole.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    private final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = {""}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("test");
    }
}
