package com.example.springbootadminclient.controller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = {""}, method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("index");
    }

    @RequestMapping(value = {"/hello"}, method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> home(@PathVariable String name) {
        return ResponseEntity.ok(name);
    }
}