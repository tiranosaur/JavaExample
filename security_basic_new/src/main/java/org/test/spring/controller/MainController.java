package org.test.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("hello world");
    }

    @PostMapping("/")
    public ResponseEntity<String> allow() {
        return ResponseEntity.ok("deny Post");
    }

    @GetMapping("/deny")
    public ResponseEntity<String> denied() {
        return ResponseEntity.ok("permitted");
    }
}
