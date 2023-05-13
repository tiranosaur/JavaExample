package com.example.springdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class MainController {

    @RequestMapping(value = "")
    public ResponseEntity<Object> home() {
        log.info("MainController.home");

        Map<String, String> map = new HashMap<>();
        map.put("status", "ok");
        map.put("message", "home endpoint");
        return ResponseEntity.ok(map);
    }

    @RequestMapping(value = "index")
    public ResponseEntity<Object> index() {
        log.info("MainController.index");

        Map<String, String> map = new HashMap<>();
        map.put("status", "ok");
        map.put("message", "index - endpoint");
        return ResponseEntity.ok(map);
    }
}