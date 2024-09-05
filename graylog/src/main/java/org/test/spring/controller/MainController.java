package org.test.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class MainController {
    private static final Random random = new Random();

    @GetMapping("/")
    public ResponseEntity<String> index() {
        log.info("===================== index.hello [{}]===================== ", random.nextInt());
        return ResponseEntity.ok("===================== Hello ==========================");
    }
}
