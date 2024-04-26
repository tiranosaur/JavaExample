package org.example.flux.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.flux.model.User;
import org.example.flux.service.UserService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Flux<User> get() {
        return Flux.fromIterable(userService.getAll()).log();
    }

    @GetMapping("{id}")
    public Mono<User> get(@PathVariable String id) {
        return Mono.just(userService.get(UUID.fromString(id)));
    }

    @GetMapping("xxx")
    public Mono<Map<String, String>> getMap() {
        return WebClient.create()
                .get()
                .uri("https://filesamples.com/samples/code/json/1sample1.json")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {
                })
                .doOnError(error -> log.error("Error: {}", error.getMessage()))
                .doOnNext(result -> log.info("Result: {}", result));
    }
}

