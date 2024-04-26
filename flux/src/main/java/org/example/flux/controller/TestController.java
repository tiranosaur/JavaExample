package org.example.flux.controller;

import org.example.flux.model.TestModel;
import org.example.flux.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
