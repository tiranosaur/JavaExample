package org.test.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.spring.api.HelloApi;
import org.test.spring.model.HelloDTO;

@Slf4j
@RestController
public class MainController implements HelloApi {
    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("/*mainService.hello()*/");
    }

    @Override
    public ResponseEntity<HelloDTO> hello() {
        HelloDTO helloDTO = HelloDTO.builder()
                .setMessage("Hello World")
                .build();
        return ResponseEntity.ok(helloDTO);
    }
}
