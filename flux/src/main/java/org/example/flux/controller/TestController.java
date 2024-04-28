package org.example.flux.controller;

import org.example.flux.model.TestModel;
import org.example.flux.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RestController
public class TestController {
    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("test")
    public Mono<TestModel> test() {
        return testService.test();
    }

    @GetMapping("error")
    public Mono<TestModel> getError() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "custom error, this error is mine"));
    }
}
