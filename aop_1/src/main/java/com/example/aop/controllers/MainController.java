package com.example.aop.controllers;

import com.example.aop.services.FirstService;
import com.example.aop.services.SecondService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MainController {
    @Autowired
    private FirstService firstService;
    @Autowired
    private SecondService secondService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> index() throws InterruptedException {
        secondService.delay();
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/retry", method = RequestMethod.GET)
    public ResponseEntity<Object> retry() throws InterruptedException {
        secondService.delay();
        return ResponseEntity.ok("");
    }
}
